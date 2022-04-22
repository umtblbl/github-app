package com.github.commons.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.github.commons.views.databinding.ItemUserInfoViewBinding

class UserInfoItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: ItemUserInfoViewBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.item_user_info_view,
        this,
        true
    )

    fun valueText(text: String) {
        binding.valueTextView.text = text
    }

    fun valueKeyText(text: String) {
        binding.valueKeyTextView.text = text
    }
}

@BindingAdapter("android:userValue")
fun setUserValue(view: UserInfoItemView, value: Int) {
    view.valueText(value.toString())
}

@BindingAdapter("android:valueKey")
fun setUserValueKey(view: UserInfoItemView, value: String) {
    view.valueKeyText(value)
}
