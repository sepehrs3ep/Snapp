package ir.snapp.assignment.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
fun Boolean?.isFalseOrNull(): Boolean {
    return when {
        this == null -> true
        else -> !this
    }
}

fun <T : Any?> LiveData<T>.observeWithInitUpdate(owner: LifecycleOwner, observer: Observer<T>) {
    this.observe(owner, observer)
    observer.onChanged(value)
}