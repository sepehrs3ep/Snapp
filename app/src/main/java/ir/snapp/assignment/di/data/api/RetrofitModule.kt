package ir.snapp.assignment.di.data.api

import dagger.Module
import dagger.Provides
import ir.snapp.assignment.data.api.RetrofitProvider
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Module
object RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return RetrofitProvider.getRetrofit()
    }
}