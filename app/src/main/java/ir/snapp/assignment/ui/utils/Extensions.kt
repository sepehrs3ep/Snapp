package ir.snapp.assignment.ui.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
fun Context?.toast(message: String, duration: Int = Toast.LENGTH_LONG) {
    this?.let {
        Toast.makeText(it, message, duration).show()
    }
}

fun Context?.toast(@StringRes resId: Int, duration: Int = Toast.LENGTH_LONG) {
    this?.let {
        Toast.makeText(it, it.getString(resId), duration).show()
    }
}

fun AppCompatImageView.setSrcCompat(
    @DrawableRes icon: Int
) {
    this.setImageDrawable(
        ContextCompat.getDrawable(
            this.context,
            icon
        )
    )
}