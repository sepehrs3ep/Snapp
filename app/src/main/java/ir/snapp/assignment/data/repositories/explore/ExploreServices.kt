package ir.snapp.assignment.data.repositories.explore

import ir.snapp.assignment.data.models.explore.VehiclesResponseWrapper
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
interface ExploreServices {

    @GET("assets/test/document.json")
    suspend fun getVehiclesList(): Response<VehiclesResponseWrapper>
}