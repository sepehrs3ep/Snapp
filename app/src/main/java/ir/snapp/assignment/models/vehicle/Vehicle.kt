package ir.snapp.assignment.models.vehicle

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
data class Vehicle(
    @Expose
    @SerializedName("type")
    val type: String,
    @Expose
    @SerializedName("lat")
    val lat: Double,
    @Expose
    @SerializedName("lng")
    val lng: Double,
    @Expose
    @SerializedName("bearing")
    val bearing: Long,
    @Expose
    @SerializedName("image_url")
    val imageUrl: String
) {
    val formattedType: VehicleType
        get() = VehicleType.parse(type)
}