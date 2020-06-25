package ir.snapp.assignment.di.data.explore

import dagger.Module
import dagger.Provides
import ir.snapp.assignment.data.api.RetrofitProvider
import ir.snapp.assignment.data.repositories.explore.ExploreServices
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Module
object ExploreModule {
    @Provides
    @Singleton
    fun provideExploreApiServices(retrofit: Retrofit): ExploreServices {
        return RetrofitProvider.provideService(
            retrofit,
            ExploreServices::class.java
        )
    }
}
