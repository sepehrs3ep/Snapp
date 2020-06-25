package ir.snapp.assignment.di.data.persistent

import android.content.Context
import dagger.Module
import dagger.Provides
import ir.snapp.assignment.data.persistent.AppDatabase
import ir.snapp.assignment.data.persistent.vehicle.VehicleDao
import ir.snapp.assignment.di.app.ApplicationContext
import javax.inject.Singleton

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Module
object PersistentModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getAppDataBase(context)
    }

    @Provides
    @Singleton
    fun provideVehicleDao(appDatabase: AppDatabase): VehicleDao {
        return appDatabase.vehicleDao()
    }
}