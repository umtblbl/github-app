package com.github.commons.ui.binding

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import com.github.commons.ui.R
import kotlin.random.Random

@set:BindingAdapter("visible")
var View.visible
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

@BindingAdapter("imageUrl", "imagePlaceholder", requireAll = false)
fun ImageView.imageUrl(url: String?, @DrawableRes placeholderId: Int?) {
    load(url) {
        crossfade(true)
        placeholder(
            placeholderId?.let {
                ContextCompat.getDrawable(context, it)
            } ?: run {
                val placeholdersColors = resources.getStringArray(R.array.placeholders)
                val placeholderColor = placeholdersColors[Random.nextInt(placeholdersColors.size)]
                ColorDrawable(Color.parseColor(placeholderColor))
            }
        )
    }
}
