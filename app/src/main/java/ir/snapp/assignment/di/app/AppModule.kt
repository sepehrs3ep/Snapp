package ir.snapp.assignment.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ir.snapp.assignment.App
import javax.inject.Singleton

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Suppress("unused")
@Module
object AppModule {
    @Provides
    @Singleton
    @ApplicationContext
    fun provideApplicationContext(app: App): Context {
        return app.applicationContext
    }
}