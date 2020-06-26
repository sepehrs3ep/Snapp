package ir.snapp.assignment.models

import com.mapbox.mapboxsdk.geometry.LatLng

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
data class Marker(
    val latLng: LatLng,
    val iconUrl: String
)