package com.github.core.di

import com.github.core.data.local.room.dataSource.GithubLocalDataSource
import com.github.core.data.remote.api.dataSource.GithubRemoteDataSource
import com.github.core.di.module.RepositoryModule
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RepositoryModuleTest {

    private lateinit var repositoryModule: RepositoryModule

    @Before
    fun setUp() {
        repositoryModule = RepositoryModule()
    }

    @Test
    fun verifyProvidedGithubRepository() {
        val githubLocalDataSource = mockk<GithubLocalDataSource>()
        val githubRemoteDataSource = mockk<GithubRemoteDataSource>()
        val githubRepository = repositoryModule.provideGithubRepository(
            githubRemoteDataSource,
            githubLocalDataSource
        )

        Assert.assertEquals(githubLocalDataSource, githubRepository.githubLocalDataSource)
        Assert.assertEquals(githubRemoteDataSource, githubRepository.githubRemoteDataSource)
    }
}