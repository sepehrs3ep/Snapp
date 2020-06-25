package ir.snapp.assignment.data.repositories.explore

import ir.snapp.assignment.data.utils.ApiErrorHandler
import ir.snapp.assignment.data.utils.BaseAPIDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Singleton
class ExploreApiDataSource @Inject constructor(
    private val service: ExploreServices,
    errorHandler: ApiErrorHandler
) : BaseAPIDataSource(errorHandler) {

    suspend fun getVehiclesList() = getResult {
        service.getVehiclesList()
    }
}