package ir.snapp.assignment.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
abstract class BindingViewHolder<T>(item: View) : RecyclerView.ViewHolder(item) {
    abstract fun bind(data: T)
}