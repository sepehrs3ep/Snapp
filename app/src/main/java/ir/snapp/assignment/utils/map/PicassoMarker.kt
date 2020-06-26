package ir.snapp.assignment.utils.map

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.mapbox.mapboxsdk.annotations.IconFactory
import com.mapbox.mapboxsdk.annotations.Marker
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import timber.log.Timber

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
class PicassoMarker(
    val marker: Marker,
    private val iconFactory: IconFactory
) : Target {
    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
        Timber.d("picassoMarker onPrepareLoad : ")
    }

    override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
        Timber.e("picassoMarker onBitmapFailed: ")
    }

    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
        try {
            if (bitmap != null) {
                marker.icon = iconFactory.fromBitmap(bitmap)
            }
        } catch (ex: IllegalArgumentException) {
            Timber.e(ex, "Marker is dead")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other is PicassoMarker) {
            return marker == other
        }
        return false
    }

    override fun hashCode(): Int {
        return marker.hashCode()
    }
}