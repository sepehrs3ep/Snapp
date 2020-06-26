package ir.snapp.assignment.data.models.explore

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ir.snapp.assignment.models.vehicle.Vehicle

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
data class VehiclesResponseWrapper(
    @Expose
    @SerializedName("vehicles")
    val vehiclesList: List<Vehicle>
)