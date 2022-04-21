package com.github.android

import android.content.Context
import com.github.android.di.DaggerAppComponent
import com.github.core.di.CoreComponent
import com.github.core.di.DaggerCoreComponent
import com.github.core.di.module.ContextModule
import com.google.android.play.core.splitcompat.SplitCompatApplication

/**
 * Base class to maintain application state and start base jobs.
 * Module inherits from SplitCompatApplication for an application approach
 *
 * @see SplitCompatApplication
 */
class GithubApp : SplitCompatApplication() {

    lateinit var coreComponent: CoreComponent

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as? GithubApp)?.coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initCoreDI()
        initAppDI()
    }

    //region private functions

    private fun initCoreDI() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

    private fun initAppDI() {
        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }

    //endregion
}
