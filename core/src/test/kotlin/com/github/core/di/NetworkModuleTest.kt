package com.github.core.di

import com.github.core.BuildConfig
import com.github.core.data.remote.api.GithubAPI
import com.github.core.di.module.NetworkModule
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit

class NetworkModuleTest {

    private lateinit var networkModule: NetworkModule

    @Before
    fun setUp() {
        networkModule = NetworkModule()
    }

    @Test
    fun verifyProvidedHttpClient() {
        val httpClient = networkModule.provideOkhttpClient()

        assertEquals(1, httpClient.interceptors.size)
    }

    @Test
    fun verifyProvidedRetrofitBuilder() {
        val okHttp = networkModule.provideOkhttpClient()
        val retrofit = networkModule.provideRetrofit(okHttp)

        assertEquals(BuildConfig.GITHUB_API_BASE_URL, retrofit.baseUrl().toUrl().toString())
    }

    @Test
    fun verifyProvidedGithubService() {
        val retrofit = mockk<Retrofit>()
        val githubAPI = mockk<GithubAPI>()
        val serviceClassCaptor = slot<Class<*>>()

        every { retrofit.create<GithubAPI>(any()) } returns githubAPI

        networkModule.provideGithubAPI(retrofit)

        verify { retrofit.create(capture(serviceClassCaptor)) }
        assertEquals(GithubAPI::class.java, serviceClassCaptor.captured)
    }
}
