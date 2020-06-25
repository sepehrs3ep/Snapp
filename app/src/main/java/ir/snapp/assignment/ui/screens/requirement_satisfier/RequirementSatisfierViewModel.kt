package ir.snapp.assignment.ui.screens.requirement_satisfier

import ir.snapp.assignment.components.permission.PermissionProvider
import ir.snapp.assignment.ui.utils.owner_view_model.OwnerViewModel
import javax.inject.Inject

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
class RequirementSatisfierViewModel @Inject constructor(
    private val permissionProvider: PermissionProvider
) : OwnerViewModel<RequirementSatisfierViewModelOwner>()
