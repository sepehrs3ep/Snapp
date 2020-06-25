package ir.snapp.assignment.ui.screens.requirement_satisfier

import ir.snapp.assignment.R

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
sealed class RequirementSatisfierDataModel(
    val icon: Int,
    val bio: Int,
    val body: Int,
    val action: Int
) {
    object Permission : RequirementSatisfierDataModel(
        R.drawable.ic_permission_off,
        R.string.permission_bio,
        R.string.permission_body,
        R.string.permission_action
    )

    object Location : RequirementSatisfierDataModel(
        R.drawable.ic_location_off,
        R.string.location_bio,
        R.string.location_body,
        R.string.location_action
    )
}