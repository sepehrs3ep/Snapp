package ir.snapp.assignment.di.screen

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ir.snapp.assignment.di.screen.dashboard.DashboardViewModelsModule
import ir.snapp.assignment.di.utils.view_model.ViewModelFactory

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Module(
    includes = [
        DashboardViewModelsModule::class
    ]
)
abstract class ViewModelsModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}