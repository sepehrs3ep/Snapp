package ir.snapp.assignment.ui.screens.dashboard.fragments.explore_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import ir.snapp.assignment.R
import ir.snapp.assignment.data.repositories.explore.ExploreSingleSourceOfTruthDataSource
import ir.snapp.assignment.data.utils.Result
import ir.snapp.assignment.models.vehicle.Vehicle
import ir.snapp.assignment.ui.utils.BaseViewModel
import ir.snapp.assignment.utils.live_data.SingleLiveEvent
import javax.inject.Inject

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
class ExploreListViewModel @Inject constructor(
    singleSourceOfTruthDataSource: ExploreSingleSourceOfTruthDataSource
) : BaseViewModel() {

    private val _vehicles = MutableLiveData<List<Vehicle>>()
    val vehicles: LiveData<List<Vehicle>> = _vehicles

    private val vehiclesList: MutableList<Vehicle> = ArrayList()

    val closeSignal = SingleLiveEvent<Nothing>()
    val toast = SingleLiveEvent<Int>()

    init {
        observe(
            singleSourceOfTruthDataSource.exploreVehicles(),
            Observer {
                when (it) {
                    is Result.Success -> {
                        vehiclesList.clear()
                        vehiclesList.addAll(it.data)
                        _vehicles.value = ArrayList(vehiclesList)
                    }
                    is Result.Error -> {
                        if (vehiclesList.isEmpty()) {
                            toast.value = R.string.explore_list_failed
                            closeSignal.call()
                        }
                    }
                }
            }
        )
    }

}