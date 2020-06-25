package ir.snapp.assignment.ui.screens.dashboard

import androidx.lifecycle.Observer
import ir.snapp.assignment.components.permission.PermissionProvider
import ir.snapp.assignment.ui.navigation.NavigationViewModel
import ir.snapp.assignment.utils.gps.GpsStateMonitor
import javax.inject.Inject

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
class DashboardViewModel @Inject constructor(
    gpsStateMonitor: GpsStateMonitor,
    permissionProvider: PermissionProvider
) : NavigationViewModel() {

    init {
        observeWithInitUpdate(
            gpsStateMonitor.hasGps,
            Observer {
                if (permissionProvider.isLocationAvailableAndAccessible().not()) {
                    navigate(DashboardFragmentDirections.navigateToRequirementSatisfierFragment())
                }
            }
        )
    }
}