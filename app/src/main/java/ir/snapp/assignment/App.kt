package ir.snapp.assignment

import android.app.Application
import ir.snapp.assignment.components.logging.Logger

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Logger.init()
    }
}