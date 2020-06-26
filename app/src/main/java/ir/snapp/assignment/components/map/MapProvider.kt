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
    lateinit var map: MapboxMap

    private val _onMapReady = MutableLiveData(false)
    val onMapReady: LiveData<Boolean> = _onMapReady

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
                _onMapReady.value = true
            }
        }
    }

    fun isMapReady() = this::map.isInitialized
}