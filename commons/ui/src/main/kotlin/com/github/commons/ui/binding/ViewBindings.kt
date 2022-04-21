package com.github.commons.ui.binding

import android.view.View
import androidx.databinding.BindingAdapter

@set:BindingAdapter("visible")
var View.visible
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }