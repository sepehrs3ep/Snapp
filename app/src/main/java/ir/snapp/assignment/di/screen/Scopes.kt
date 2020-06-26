package ir.snapp.assignment.di.screen

import javax.inject.Scope

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class PerFragment