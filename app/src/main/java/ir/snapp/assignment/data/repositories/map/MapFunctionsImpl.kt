package ir.snapp.assignment.data.repositories.map

import com.mapbox.mapboxsdk.annotations.Marker
import com.mapbox.mapboxsdk.camera.CameraUpdate
import ir.snapp.assignment.components.map.MapProvider
import ir.snapp.assignment.components.map.MapUtils
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Singleton
class MapFunctionsImpl @Inject constructor(
    private val mapProvider: MapProvider,
    private val mapUtils: MapUtils
) : MapFunctions {
    private val markersList: MutableList<Marker> = ArrayList()

    override fun moveCameraSmoothly(cameraUpdate: CameraUpdate) {
        mapProvider.map.animateCamera(cameraUpdate, CAMERA_ANIMATE_DELAY_MILLI_SECOND)
    }

    override fun addMarker(marker: ir.snapp.assignment.models.Marker): Marker {
        val mapMarker = mapUtils.addMarker(marker)
        markersList.add(mapMarker)
        return mapMarker
    }

    override fun removeMarker(marker: Marker) {
        markersList.remove(marker)
        marker.remove()
    }

    companion object {
        private const val CAMERA_ANIMATE_DELAY_MILLI_SECOND = 400
    }
}