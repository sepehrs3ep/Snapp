package ir.snapp.assignment.ui.screens.dashboard

import androidx.lifecycle.Observer
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.viewModelScope
import com.mapbox.mapboxsdk.annotations.Marker
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLngBounds
import ir.snapp.assignment.R
import ir.snapp.assignment.components.map.MapProvider
import ir.snapp.assignment.components.permission.PermissionProvider
import ir.snapp.assignment.components.resource.ResourceManager
import ir.snapp.assignment.data.repositories.explore.ExploreSingleSourceOfTruthDataSource
import ir.snapp.assignment.data.repositories.map.MapFunctionsImpl
import ir.snapp.assignment.data.utils.Result
import ir.snapp.assignment.models.vehicle.Vehicle
import ir.snapp.assignment.ui.navigation.NavigationViewModel
import ir.snapp.assignment.utils.gps.GpsStateMonitor
import ir.snapp.assignment.utils.isFalseOrNull
import ir.snapp.assignment.utils.live_data.SingleLiveEvent
import ir.snapp.assignment.utils.map.toLocations
import ir.snapp.assignment.utils.map.toMarker
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
class DashboardViewModel @Inject constructor(
    gpsStateMonitor: GpsStateMonitor,
    private val permissionProvider: PermissionProvider,
    private val exploreSingleSourceOfTruthDataSource: ExploreSingleSourceOfTruthDataSource,
    private val mapProvider: MapProvider,
    private val mapFunctionsImpl: MapFunctionsImpl,
    private val resourceManager: ResourceManager
) : NavigationViewModel() {
    val messageEvent = SingleLiveEvent<String>()

    private val vehiclesList: MutableList<Vehicle> = ArrayList()
    private val vehiclesMarkers: MutableList<Marker> = ArrayList()

    private var isFetching = false

    private val vehiclesListResponseObserver = Observer<Result<List<Vehicle>>> {
        when (it) {
            is Result.Loading -> fullscreenLoading.value = true

            is Result.Success -> {
                vehiclesList.clear()
                vehiclesList.addAll(it.data)
                viewModelScope.launch {
                    delay(SHOW_VEHICLES_DELAY_MILLI_SECOND)

                    showVehiclesOnMap()

                    fullscreenLoading.value = false
                    isFetching = false
                }
            }

            is Result.Error -> {
                fullscreenLoading.value = false
                messageEvent.value = it.error.message
                isFetching = false

                if (vehiclesList.isNotEmpty()) {
                    viewModelScope.launch {
                        delay(BOUND_CAMERA_TO_POINT_DELAY_MILLI_SECOND)

                        navigateToExploreList()
                    }
                }
            }
        }
    }

    init {
        observe(
            gpsStateMonitor.hasGps,
            Observer {
                if (permissionProvider.isLocationAvailableAndAccessible().not()) {
                    navigate(DashboardFragmentDirections.navigateToRequirementSatisfierFragment())
                }
            }
        )

        observe(
            mapProvider
                .mapAvailability
                .distinctUntilChanged(),
            Observer {
                if (it.isFalseOrNull()) {
                    removeMapMarkers()
                } else {
                    exploreVehicles()
                }
            }
        )
    }

    private fun exploreVehicles() {
        if (
            permissionProvider.isLocationAvailableAndAccessible().not() ||
            isFetching
        ) return

        isFetching = true

        observe(
            exploreSingleSourceOfTruthDataSource.exploreVehicles(),
            vehiclesListResponseObserver
        )
    }

    private fun showVehiclesOnMap() {
        if (
            mapProvider.isMapReady().not() ||
            vehiclesList.isEmpty()
        ) return

        removeMapMarkers()

        drawMarkers()

        boundCameraToPoints()
    }

    private fun drawMarkers() {
        vehiclesList.forEach {
            vehiclesMarkers.add(
                mapFunctionsImpl.addMarker(
                    it.toMarker()
                )
            )
        }
    }

    private fun boundCameraToPoints() {
        viewModelScope.launch {
            delay(BOUND_CAMERA_TO_POINT_DELAY_MILLI_SECOND)

            val latLngBounds: LatLngBounds.Builder = LatLngBounds.Builder()
                .includes(vehiclesList.toLocations())

            mapFunctionsImpl.moveCameraSmoothly(
                CameraUpdateFactory.newLatLngBounds(
                    latLngBounds.build(),
                    resourceManager.getDimenPixel(R.dimen.map_bound_padding)
                )
            )
        }
    }

    private fun removeMapMarkers() {
        vehiclesMarkers.forEach {
            mapFunctionsImpl.removeMarker(it)
        }
        vehiclesMarkers.clear()
    }

    fun navigateToExploreList() {
        navigate(
            DashboardFragmentDirections.navigateToExploreList()
        )
    }

    fun focusOnVehicles() {
        if (mapProvider.isMapReady().not()) return

        if (vehiclesList.isEmpty()) {
            exploreVehicles()
            return
        }

        showVehiclesOnMap()
    }

    companion object {
        private const val SHOW_VEHICLES_DELAY_MILLI_SECOND = 1000L
        private const val BOUND_CAMERA_TO_POINT_DELAY_MILLI_SECOND = 500L
    }
}