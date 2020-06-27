package ir.snapp.assignment.ui.screens.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.snapp.assignment.R
import ir.snapp.assignment.components.map.MapProvider
import ir.snapp.assignment.ui.navigation.NavigationViewModel
import ir.snapp.assignment.ui.utils.BaseMapFragment
import ir.snapp.assignment.ui.utils.toast
import ir.snapp.assignment.utils.network.ConnectionStateMonitor
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.no_internet_connection_layout.*
import javax.inject.Inject

class DashboardFragment : BaseMapFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var mapProvider: MapProvider

    @Inject
    lateinit var connectionStateMonitor: ConnectionStateMonitor

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

        showVehiclesBtn.setOnClickListener {
            viewModel.focusOnVehicles()
        }

        connectionStateMonitor.hasInternet.observe(
            viewLifecycleOwner,
            Observer {
                val visibility = if (it) View.GONE else View.VISIBLE
                noInternetRoot.visibility = visibility
            }
        )

        crossIv.setOnClickListener {
            noInternetRoot.visibility = View.GONE
        }

        viewModel.messageEvent.observe(
            viewLifecycleOwner,
            Observer {
                it?.let {
                    requireContext().toast(it)
                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mapProvider.onAvailabilityChanged(false)
    }
}