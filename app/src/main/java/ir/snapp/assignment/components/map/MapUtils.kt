package ir.snapp.assignment.components.map

import android.content.Context
import android.graphics.Bitmap
import com.mapbox.mapboxsdk.annotations.IconFactory
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.squareup.picasso.Picasso
import ir.snapp.assignment.R
import ir.snapp.assignment.di.app.ApplicationContext
import ir.snapp.assignment.models.Marker
import ir.snapp.assignment.utils.map.PicassoMarker
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Singleton
class MapUtils @Inject constructor(
    private val mapProvider: MapProvider,
    @ApplicationContext private val context: Context
) {
    private val iconFactory = IconFactory.getInstance(context)

    fun addMarker(marker: Marker): com.mapbox.mapboxsdk.annotations.Marker {
        val markerOption = MarkerOptions().position(marker.latLng).apply {
            icon = iconFactory
                .fromBitmap(
                    Bitmap.createBitmap(
                        1,
                        1,
                        Bitmap.Config.ARGB_8888
                    )
                )
        }

        val picassoMarker = PicassoMarker(
            mapProvider.map.addMarker(markerOption),
            iconFactory
        )

        try {
            val picasso = Picasso.get().apply {
                this.isLoggingEnabled = true
            }

            picasso.load(marker.iconUrl)
                .centerInside()
                .noPlaceholder()
                .resizeDimen(
                    R.dimen.marker_width,
                    R.dimen.marker_height
                )
                .into(picassoMarker)
        } catch (ex: Exception) {
            Timber.e(ex, "Picasso crashed")
        }
        return picassoMarker.marker
    }

}