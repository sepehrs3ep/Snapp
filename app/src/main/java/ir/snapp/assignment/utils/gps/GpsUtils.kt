package ir.snapp.assignment.utils.gps

import android.content.Context
import android.location.LocationManager

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
fun Context.isGpsAvailable(): Boolean {
    val locationManager: LocationManager? = this.getSystemService(
        Context.LOCATION_SERVICE
    ) as LocationManager

    return locationManager != null &&
            locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) &&
            locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
}