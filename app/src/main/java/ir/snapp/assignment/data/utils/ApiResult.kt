package ir.snapp.assignment.data.utils

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
sealed class ApiResult<out T> {
    data class Success<T>(val data: T?) : ApiResult<T>()
    data class Error(
        val error: ir.snapp.assignment.models.Error
    ) : ApiResult<Nothing>()

    companion object {
        const val FAILED_ERROR_CODE = 600
    }
}