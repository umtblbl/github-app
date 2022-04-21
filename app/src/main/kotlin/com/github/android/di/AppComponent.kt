package com.github.android.di

import com.github.android.GithubApp
import com.github.core.di.CoreComponent
import com.github.core.di.scope.AppScope
import dagger.Component

/**
 * App component that application component's components depend on.
 *
 * @see Component
 */
@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    /**
     * Inject dependencies on application.
     *
     * @param application The sample application.
     */
    fun inject(application: GithubApp)
}
