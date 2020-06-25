package ir.snapp.assignment.ui.screens.dashboard

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

class DashboardFragment : NavigationFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: DashboardViewModel by viewModels { viewModelFactory }
    override fun getViewModel(): NavigationViewModel = viewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }
}