package ir.snapp.assignment.di.data

import android.content.Context
import dagger.Module
import dagger.Provides
import ir.snapp.assignment.data.utils.KeyValueStorage
import ir.snapp.assignment.di.app.ApplicationContext
import ir.snapp.assignment.di.data.api.RetrofitModule
import ir.snapp.assignment.di.data.explore.ExploreModule
import ir.snapp.assignment.di.data.persistent.PersistentModule
import javax.inject.Singleton

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Module(
    includes = [
        RetrofitModule::class,
        ExploreModule::class,
        PersistentModule::class
    ]
)
object DataModule {

    @Provides
    @Singleton
    fun provideKeyValueStorage(
        @ApplicationContext context: Context
    ): KeyValueStorage {
        return KeyValueStorage(
            KeyValueStorage.getPrivateSharedPreferences(
                context
            )
        )
    }
}