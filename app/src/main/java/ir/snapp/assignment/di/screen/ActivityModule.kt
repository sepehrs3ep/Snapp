package ir.snapp.assignment.di.screen

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.snapp.assignment.di.screen.dashboard.DashboardActivityModule
import ir.snapp.assignment.ui.screens.dashboard.DashboardActivity

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Suppress("unused")
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(
        modules = [
            DashboardActivityModule::class
        ]
    )
    @PerActivity
    abstract fun contributeDashboardActivity(): DashboardActivity
}