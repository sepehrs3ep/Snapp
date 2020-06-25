package ir.snapp.assignment.ui.screens.requirement_satisfier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import ir.snapp.assignment.R
import ir.snapp.assignment.ui.navigation.NavigationFragment
import ir.snapp.assignment.ui.navigation.NavigationViewModel
import javax.inject.Inject

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
class RequirementSatisfierFragment : NavigationFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: RequirementSatisfierViewModel by viewModels { viewModelFactory }
    override fun getViewModel(): NavigationViewModel = viewModel

    private val viewModelOwner =
        object : RequirementSatisfierViewModelOwner {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_requirement_satisfier, container, false)
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart(viewModelOwner)
    }

    override fun onStop() {
        viewModel.onStop()
        super.onStop()
    }
}
