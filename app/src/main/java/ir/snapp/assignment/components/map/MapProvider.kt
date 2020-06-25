package ir.snapp.assignment.components.map

import android.content.Context
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapboxMap
import ir.snapp.assignment.R
import ir.snapp.assignment.utils.map.initMap
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

    companion object {
        fun init(context: Context) {
            Mapbox.getInstance(context, context.getString(R.string.mapbox_access_token))
        }
    }

    fun onMapReady(map: MapboxMap) {
        map.initMap()
    }
}