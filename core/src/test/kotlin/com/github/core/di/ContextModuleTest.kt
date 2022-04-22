package com.github.core.di

import android.app.Application
import com.github.core.di.module.ContextModule
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ContextModuleTest {

    @MockK(relaxed = true)
    lateinit var application: Application
    private lateinit var contextModule: ContextModule

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        contextModule = ContextModule(application)
    }

    @Test
    fun verifyProvidedContext() {
        Assert.assertEquals(application, contextModule.provideContext())
    }
}
