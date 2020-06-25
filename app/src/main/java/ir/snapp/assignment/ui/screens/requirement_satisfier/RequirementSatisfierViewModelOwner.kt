package ir.snapp.assignment.ui.screens.requirement_satisfier

import com.google.android.gms.location.LocationSettingsResponse
import com.google.android.gms.tasks.Task
import ir.snapp.assignment.ui.utils.owner_view_model.BaseViewModelOwner

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
interface RequirementSatisfierViewModelOwner : BaseViewModelOwner {
    fun getLocationSettingTask(): Task<LocationSettingsResponse>
}