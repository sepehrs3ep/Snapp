package ir.snapp.assignment.ui.utils

import android.app.Dialog
import android.content.Context
import ir.snapp.assignment.R

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
class FullScreenLoadingDialog private constructor(context: Context) {
    private val dialog: Dialog = Dialog(
        context,
        R.style.Theme_App_Dialog_FullScreen
    )

    init {
        dialog.setContentView(R.layout.dialog_full_screen_progress_view)
        dialog.setCancelable(false)
    }

    fun show() {
        dialog.show()
    }

    fun hide() {
        dialog.hide()
    }

    fun dismiss() {
        dialog.dismiss()
    }

    companion object {
        fun getNewInstance(context: Context): FullScreenLoadingDialog {
            return FullScreenLoadingDialog(context)
        }
    }
}