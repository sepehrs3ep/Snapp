package ir.snapp.assignment.ui.navigation

import androidx.navigation.NavDirections
import ir.snapp.assignment.ui.utils.BaseViewModel
import ir.snapp.assignment.utils.live_data.SingleLiveEvent

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Suppress("unused")
abstract class NavigationViewModel : BaseViewModel() {
    val navigationCommands: SingleLiveEvent<NavigationCommand> =
        SingleLiveEvent()

    fun navigate(directions: NavDirections) {
        navigationCommands.postValue(NavigationCommand.To(directions))
    }

    fun navigate(command: NavigationCommand) {
        navigationCommands.postValue(command)
    }
}