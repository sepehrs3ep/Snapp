package ir.snapp.assignment.ui.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.mapbox.mapboxsdk.maps.MapView
import ir.snapp.assignment.R
import ir.snapp.assignment.ui.navigation.NavigationFragment

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
abstract class BaseMapFragment : NavigationFragment() {
    protected lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getMapLayoutContainer(), container, false)

        val mapView: MapView = view.findViewById(R.id.mapView)
            ?: throw RuntimeException("View Container should contain map view with mapView layout ID")

        this.mapView = mapView
        this.mapView.onCreate(savedInstanceState)

        return view.rootView
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    @LayoutRes
    abstract fun getMapLayoutContainer(): Int
}