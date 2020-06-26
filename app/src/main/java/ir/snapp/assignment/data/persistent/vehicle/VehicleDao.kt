package ir.snapp.assignment.data.persistent.vehicle

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import ir.snapp.assignment.data.persistent.BaseDao
import ir.snapp.assignment.models.vehicle.Vehicle

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Dao
interface VehicleDao : BaseDao<Vehicle> {
    @Query("SELECT * FROM Vehicle")
    fun getAll(): LiveData<List<Vehicle>>

    @Query("SELECT * FROM Vehicle")
    suspend fun getAllInstantly(): List<Vehicle>

    @Query("DELETE FROM Vehicle")
    suspend fun clear()
}