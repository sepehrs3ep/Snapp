package ir.snapp.assignment.ui.screens.splash

import android.content.Intent
import android.os.Bundle
import ir.snapp.assignment.ui.screens.dashboard.DashboardActivity
import ir.snapp.assignment.ui.utils.BaseActivity

/**
 * Created by Sepehr Sadri on 6/27/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this@SplashActivity, DashboardActivity::class.java))

        finish()
    }
}