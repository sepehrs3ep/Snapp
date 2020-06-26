package ir.snapp.assignment.data.utils

import android.content.Context
import ir.snapp.assignment.BuildConfig
import ir.snapp.assignment.R
import ir.snapp.assignment.di.app.ApplicationContext
import ir.snapp.assignment.utils.network.isNetworkAvailable
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Singleton
class ApiErrorHandler @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun onFailed(ex: Exception): ApiResult.Error {
        val message =
            when {
                context.isNetworkAvailable().not() -> {
                    R.string.error_no_internet
                }
                ex is HttpException -> {
                    R.string.error_server_error
                }
                else -> {
                    R.string.error_unknown
                }
            }

        return ApiResult.Error(
            ir.snapp.assignment.models.Error(
                ApiResult.FAILED_ERROR_CODE,
                getString(message)
            )
        )
    }

    fun <T> onError(response: Response<T>): ApiResult<T> {
        val code = response.code()

        if (context.isNetworkAvailable().not()) {
            return ApiResult.Error(
                ir.snapp.assignment.models.Error(
                    code,
                    getString(R.string.error_no_internet)
                )
            )
        }

        val responseMessage =
            if (BuildConfig.DEBUG) {
                response.errorBody()?.toString() ?: getString(R.string.error_unknown)
            } else {
                getString(R.string.error_unknown)
            }

        return ApiResult.Error(
            ir.snapp.assignment.models.Error(
                code,
                responseMessage
            )
        )
    }

    private fun getString(text: Int) =
        context.resources.getString(text)
}