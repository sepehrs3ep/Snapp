package ir.snapp.assignment.di.screen.dashboard

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.snapp.assignment.di.screen.PerFragment
import ir.snapp.assignment.ui.screens.dashboard.DashboardFragment
import ir.snapp.assignment.ui.screens.dashboard.fragments.explore_list.ExploreListBottomSheetDialogFragment
import ir.snapp.assignment.ui.screens.requirement_satisfier.RequirementSatisfierFragment

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Suppress("unused")
@Module
abstract class DashboardActivityModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun contributeMainDashboardFragment(): DashboardFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun contributeRequirementSatisfierFragment(): RequirementSatisfierFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun contributeExploreListBottomSheetDialogFragment():
            ExploreListBottomSheetDialogFragment
}