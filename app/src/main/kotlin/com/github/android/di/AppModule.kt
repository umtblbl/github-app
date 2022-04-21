package com.github.android.di

import android.content.Context
import com.github.android.GithubApp
import dagger.Module
import dagger.Provides

/**
 * Class that contributes to the object graph [AppComponent].
 * @see Module
 */
@Module
class AppModule {

    /**
     * Create a provider method binding for [Context].
     *
     * @param application Sample Application.
     * @return Instance of context.
     * @see Provides
     */
    @Provides
    fun provideContext(application: GithubApp): Context = application.applicationContext
}
