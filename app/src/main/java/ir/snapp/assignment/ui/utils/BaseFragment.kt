package ir.snapp.assignment.ui.utils

import android.os.Bundle
import androidx.lifecycle.Observer
import dagger.android.support.DaggerFragment
import ir.snapp.assignment.utils.isFalseOrNull
import ir.snapp.assignment.utils.observeWithInitUpdate

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
abstract class BaseFragment : DaggerFragment() {
    companion object {
        private const val KEYBOARD_SHOW_DELAY = 100L
    }

    private var loadingDialog: FullScreenLoadingDialog? = null

    fun showKeyboard() {
        view?.findFocus()?.let {
            KeyboardUtils.showSoftKeyboard(it)
        }
    }

    fun hideKeyboard() {
        view?.findFocus()?.let {
            KeyboardUtils.hideSoftKeyboard(it)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        getViewModel()?.fullscreenLoading?.observeWithInitUpdate(viewLifecycleOwner, Observer {
            handleLoadingState(it)
        })
    }

    private fun handleLoadingState(loading: Boolean?) {
        if (loading.isFalseOrNull()) {
            hideLoading()
        } else {
            showLoading()
        }
    }

    private fun hideLoading() {
        loadingDialog?.apply { hide() }
    }

    private fun showLoading() {
        if (loadingDialog == null) {
            loadingDialog = FullScreenLoadingDialog.getNewInstance(requireContext())
        }
        loadingDialog!!.show()
    }

    override fun onResume() {
        super.onResume()
        view?.postDelayed({ showKeyboard() }, KEYBOARD_SHOW_DELAY)
    }

    override fun onDestroyView() {
        if (loadingDialog != null) {
            loadingDialog!!.dismiss()
            loadingDialog = null
        }

        super.onDestroyView()
    }

    abstract fun getViewModel(): BaseViewModel?
}