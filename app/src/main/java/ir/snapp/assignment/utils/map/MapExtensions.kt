package ir.snapp.assignment.utils.map

import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapboxMap
import ir.snapp.assignment.models.Marker
import ir.snapp.assignment.models.vehicle.Vehicle

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */

fun MapboxMap.specializeMap() {
    with(this) {
        uiSettings.isZoomGesturesEnabled = true
        uiSettings.isTiltGesturesEnabled = true
        uiSettings.isRotateGesturesEnabled = true
    }
}

fun Vehicle.toLocation(): LatLng {
    return LatLng(this.lat, this.lng)
}

fun List<Vehicle>.toLocations(): List<LatLng> {
    val list: MutableList<LatLng> = ArrayList()

    this.forEach {
        list.add(it.toLocation())
    }

    return list
}

fun Vehicle.toMarker(): Marker {
    return Marker(
        this.toLocation(),
        this.imageUrl
    )
}