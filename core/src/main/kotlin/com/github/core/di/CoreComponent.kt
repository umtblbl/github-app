package com.github.core.di

import android.content.Context
import com.github.core.data.remote.api.GithubAPI
import com.github.core.data.remote.api.dataSource.GithubRemoteDataSource
import com.github.core.data.repository.GithubRepository
import com.github.core.di.module.*
import dagger.Component
import javax.inject.Singleton

/**
 * Core component that all module's components depend on.
 *
 * @see Component
 */
@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        DataSourceModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface CoreComponent {

    /**
     * Provide dependency graph Context>
     *
     * @return Context
     */
    fun context(): Context

    /**
     * Provide dependency graph MarvelService
     *
     * @return MarvelService
     */
    fun githubAPI(): GithubAPI

    /**
     * Provide dependency graph MarvelRepository
     *
     * @return MarvelRepository
     */
    fun githubRepository(): GithubRepository

    /**
     * Provide dependency graph CharacterFavoriteDao
     *
     * @return CharacterFavoriteDao
     */
    fun githubRemoteDataSource(): GithubRemoteDataSource
}
