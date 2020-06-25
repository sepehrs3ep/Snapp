package ir.snapp.assignment.di.screen.dashboard

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.snapp.assignment.di.utils.view_model.ViewModelKey
import ir.snapp.assignment.ui.screens.dashboard.DashboardViewModel
import ir.snapp.assignment.ui.screens.requirement_satisfier.RequirementSatisfierViewModel

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Suppress("unused")
@Module
abstract class DashboardViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindMainDashboardViewModel(viewModel: DashboardViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RequirementSatisfierViewModel::class)
    abstract fun bindRequirementSatisfierViewModel(
        viewModel: RequirementSatisfierViewModel
    ): ViewModel
}