package ir.snapp.assignment.data.api

import ir.snapp.assignment.BuildConfig
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
object APIUtils {
    const val API_BASE_URL = "https://snapp.ir/"

    fun getLoggingInterceptor(): Interceptor? {
        if (BuildConfig.DEBUG.not()) {
            return null
        }

        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY

        return logger
    }
}
