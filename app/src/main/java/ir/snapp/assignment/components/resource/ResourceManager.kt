package ir.snapp.assignment.components.resource

import android.content.Context
import androidx.annotation.DimenRes
import ir.snapp.assignment.di.app.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Singleton
class ResourceManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val resources = context.resources

    fun getDimenPixel(@DimenRes dimenId: Int) =
        resources.getDimensionPixelSize(dimenId)
}