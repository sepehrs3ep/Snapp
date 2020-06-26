package ir.snapp.assignment.ui.screens.dashboard.fragments.explore_list

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.DiffUtil
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso
import ir.snapp.assignment.R
import ir.snapp.assignment.models.vehicle.Vehicle
import ir.snapp.assignment.ui.adapter.BindingViewHolder
import ir.snapp.assignment.ui.adapter.GenericListAdapter

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
class ExploreAdapter(
    private val exploreListViewModel: ExploreListViewModel
) : GenericListAdapter<Vehicle, BindingViewHolder<Vehicle>>(VehicleDiffCallback()) {

    override fun getLayoutId(position: Int, obj: Vehicle) =
        R.layout.list_item_vehicle

    override fun getViewHolder(view: View, viewType: Int): BindingViewHolder<Vehicle> {
        return ExploreViewHolder(
            view,
            exploreListViewModel
        )
    }

    private class ExploreViewHolder(
        private val item: View,
        private val exploreListViewModel: ExploreListViewModel
    ) : BindingViewHolder<Vehicle>(item) {
        private val txtServiceType = item.findViewById<MaterialTextView>(
            R.id.serviceTypeTv
        )

        private val serviceTypeImg = item.findViewById<AppCompatImageView>(
            R.id.serviceIv
        )

        private lateinit var data: Vehicle

        private val clickListener = View.OnClickListener {
            // Ignore
        }

        override fun bind(data: Vehicle) {
            this.data = data

            txtServiceType.text = data.formattedType.key

            Picasso.get()
                .load(data.imageUrl)
                .into(serviceTypeImg)

            item.setOnClickListener(clickListener)
        }
    }

    private class VehicleDiffCallback : DiffUtil.ItemCallback<Vehicle>() {
        override fun areItemsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean {
            return newItem == oldItem
        }
    }
}