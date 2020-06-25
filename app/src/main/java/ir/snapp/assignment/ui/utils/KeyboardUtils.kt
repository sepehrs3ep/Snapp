package ir.snapp.assignment.ui.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Created by Sepehr Sadri on 6/25/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
object KeyboardUtils {

    fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = view.context.getSystemService(
                Context.INPUT_METHOD_SERVICE
            ) as InputMethodManager?

            imm?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun hideSoftKeyboard(view: View) {
        view.clearFocus()
        val imm = view.context.getSystemService(
            Context.INPUT_METHOD_SERVICE
        ) as InputMethodManager?

        imm?.hideSoftInputFromWindow(view.windowToken, InputMethodManager.SHOW_IMPLICIT)
    }
}