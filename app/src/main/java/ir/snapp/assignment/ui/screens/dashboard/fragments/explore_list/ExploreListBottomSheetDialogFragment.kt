package ir.snapp.assignment.ui.screens.dashboard.fragments.explore_list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import ir.snapp.assignment.R
import ir.snapp.assignment.ui.utils.toast
import kotlinx.android.synthetic.main.bottom_sheet_close_bar.*
import kotlinx.android.synthetic.main.explore_list_bottom_sheet_dialog_fragment.*
import javax.inject.Inject

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
class ExploreListBottomSheetDialogFragment : BottomSheetDialogFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ExploreListViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.explore_list_bottom_sheet_dialog_fragment,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBottomSheetClose.setOnClickListener {
            dismissAllowingStateLoss()
        }

        val adapter =
            ExploreAdapter(viewModel)

        viewModel.vehicles.observe(
            viewLifecycleOwner,
            Observer {
                adapter.submitList(it)
            }
        )

        with(rcvExplores) {
            this.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            this.adapter = adapter
        }

        viewModel.closeSignal.observe(
            viewLifecycleOwner,
            Observer {
                dismissAllowingStateLoss()
            }
        )

        viewModel.toast.observe(
            viewLifecycleOwner,
            Observer {
                it?.let {
                    requireContext().toast(it)
                }
            }
        )
    }

    // region Applying Dagger-Android dialog fragment support injector
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
    // endregion
}