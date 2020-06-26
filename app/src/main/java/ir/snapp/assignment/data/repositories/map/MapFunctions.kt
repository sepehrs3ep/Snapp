package ir.snapp.assignment.data.repositories.map

import com.mapbox.mapboxsdk.camera.CameraUpdate
import ir.snapp.assignment.models.Marker

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
interface MapFunctions {
    fun moveCameraSmoothly(cameraUpdate: CameraUpdate)
    fun addMarker(marker: Marker): com.mapbox.mapboxsdk.annotations.Marker
    fun removeMarker(marker: com.mapbox.mapboxsdk.annotations.Marker)
}