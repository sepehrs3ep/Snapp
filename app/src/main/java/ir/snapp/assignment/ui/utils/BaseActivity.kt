package ir.snapp.assignment.ui.utils

import android.annotation.SuppressLint
import dagger.android.support.DaggerAppCompatActivity
import ir.snapp.assignment.components.permission.PermissionProvider
import javax.inject.Inject

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@SuppressLint("Registered")
abstract class BaseActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var permissionProvider: PermissionProvider

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (permissionProvider.onPermissionResult(requestCode).not())
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}