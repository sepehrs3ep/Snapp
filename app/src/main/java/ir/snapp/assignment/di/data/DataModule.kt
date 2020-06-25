package ir.snapp.assignment.di.data

import dagger.Module
import ir.snapp.assignment.di.data.api.RetrofitModule

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Module(
    includes = [
        RetrofitModule::class
    ]
)
object DataModule