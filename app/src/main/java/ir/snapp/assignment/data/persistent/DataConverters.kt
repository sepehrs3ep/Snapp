package ir.snapp.assignment.data.persistent

import androidx.room.TypeConverter
import ir.snapp.assignment.models.vehicle.VehicleType

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
class DataConverters {
    @TypeConverter
    fun toHealth(value: String) = enumValueOf<VehicleType>(value)

    @TypeConverter
    fun fromHealth(value: VehicleType) = value.name
}