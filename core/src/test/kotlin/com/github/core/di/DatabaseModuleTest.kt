package com.github.core.di

import android.content.Context
import com.github.core.data.local.room.GithubDatabase
import com.github.core.data.local.room.dao.FavoriteUserDao
import com.github.core.di.module.DatabaseModule
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DatabaseModuleTest {

    private lateinit var databaseModule: DatabaseModule

    @Before
    fun setUp() {
        databaseModule = DatabaseModule()
    }

    @Test
    fun verifyProvidedGithubDatabase() {
        val context: Context = mockk()
        val githubDatabase = databaseModule.provideGithubDatabase(context)

        Assert.assertNotNull(githubDatabase.favoriteUsersDao())
    }

    @Test
    fun verifyProvidedFavoriteUsersDao() {
        val githubDatabase: GithubDatabase = mockk()
        val favoriteUserDao: FavoriteUserDao = mockk()

        every { githubDatabase.favoriteUsersDao() } returns favoriteUserDao

        assertEquals(
            favoriteUserDao,
            databaseModule.provideFavoriteUsersDao(githubDatabase)
        )
        verify { githubDatabase.favoriteUsersDao() }
    }
}
