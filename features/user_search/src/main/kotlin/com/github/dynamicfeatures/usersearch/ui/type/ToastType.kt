package com.github.dynamicfeatures.usersearch.ui.type

import com.github.dynamicfeatures.usersearch.R

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

