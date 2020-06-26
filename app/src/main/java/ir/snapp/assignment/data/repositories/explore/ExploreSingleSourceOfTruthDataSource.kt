package ir.snapp.assignment.data.repositories.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import ir.snapp.assignment.data.persistent.vehicle.VehicleDao
import ir.snapp.assignment.data.utils.ApiResult
import ir.snapp.assignment.data.utils.Result
import ir.snapp.assignment.models.vehicle.Vehicle
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Singleton
class ExploreSingleSourceOfTruthDataSource @Inject constructor(
    private val exploreApiDataSource: ExploreApiDataSource,
    private val vehicleDao: VehicleDao
) {
    fun exploreVehicles(): LiveData<Result<List<Vehicle>>> =
        liveData(Dispatchers.Main) {
            emit(Result.Loading)

            val source = vehicleDao.getAll()
                .map {
                if (it.isNullOrEmpty()) {
                    Result.Empty
                } else {
                    Result.Success(it)
                }
            }

            emitSource(source)

            apiRequest()
        }

    private suspend fun LiveDataScope<Result<List<Vehicle>>>.apiRequest() {
        when (val res = exploreApiDataSource.getVehiclesList()) {
            is ApiResult.Success -> {
                val data = res.data
                if (data != null) {
                    vehicleDao.insertAll(data.vehiclesList)
                }
            }
            is ApiResult.Error -> emit(Result.Error(res.error))
        }
    }
}