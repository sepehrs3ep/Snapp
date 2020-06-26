package ir.snapp.assignment.ui.screens.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import ir.snapp.assignment.R
import ir.snapp.assignment.components.map.MapProvider
import ir.snapp.assignment.ui.navigation.NavigationViewModel
import ir.snapp.assignment.ui.utils.BaseMapFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import javax.inject.Inject

class DashboardFragment : BaseMapFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var mapProvider: MapProvider

    private val viewModel: DashboardViewModel by viewModels { viewModelFactory }
    override fun getViewModel(): NavigationViewModel = viewModel

    override fun getMapLayoutContainer() = R.layout.fragment_dashboard

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        mapView.getMapAsync {
            mapProvider.onMapReady(it)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showExploreListBtn.setOnClickListener {
            viewModel.navigateToExploreList()
        }
    }
}