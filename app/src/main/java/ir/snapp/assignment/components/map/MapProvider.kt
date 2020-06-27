package ir.snapp.assignment.components.map

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import ir.snapp.assignment.R
import ir.snapp.assignment.utils.map.specializeMap
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Singleton
class MapProvider @Inject constructor() {
    var map: MapboxMap? = null

    private val _mapAvailability = MutableLiveData(false)
    val mapAvailability: LiveData<Boolean> = _mapAvailability

    companion object {
        fun init(context: Context) {
            Mapbox.getInstance(context, context.getString(R.string.mapbox_access_token))
        }
    }

    fun onMapReady(map: MapboxMap) {
        this.map = map
        with(map) {
            specializeMap()
            setStyle(
                Style.MAPBOX_STREETS
            ) {
                onAvailabilityChanged(true)
            }
        }
    }

    fun onAvailabilityChanged(availability: Boolean) {
        _mapAvailability.value = availability
        if (availability.not()) {
            this.map = null
        }
    }

    fun isMapReady() = this.map != null
}