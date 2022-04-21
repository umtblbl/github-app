package com.github.commons.views

import android.app.Activity
import androidx.core.content.ContextCompat
//import com.tapadoo.alerter.Alerter

class AppToast(
    private val activity: Activity?,
    private val titleResId: Int,
    private val textResId: Int,
    private val colorResId: Int
) {
    fun show() {
//        Alerter.create(activity ?: return)
//            .setBackgroundColorInt(ContextCompat.getColor(activity, colorResId))
//            .setTitle(activity.getString(titleResId))
//            .setText(activity.getString(textResId))
//            .setDuration(Configs.Toast.DURATION)
//            .show()
    }
}
