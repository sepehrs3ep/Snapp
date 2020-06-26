package ir.snapp.assignment.di.app

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ir.snapp.assignment.App
import ir.snapp.assignment.di.data.DataModule
import ir.snapp.assignment.di.screen.ActivityModule
import ir.snapp.assignment.di.screen.ViewModelsModule
import javax.inject.Singleton

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Suppress("unused")
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        DataModule::class,
        ActivityModule::class,
        ViewModelsModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}