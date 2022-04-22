package com.github.dynamicfeatures.userfavorites.ui.type

import com.github.dynamicfeatures.userfavorites.R

enum class ToastType(
    val titleResId: Int,
    val textResId: Int,
    val colorResId: Int
    ) {
    ProcessSuccessful(
        R.string.toast_process_successful_title,
        R.string.toast_process_successful_text,
        R.color.secondaryCyan
    )
}

