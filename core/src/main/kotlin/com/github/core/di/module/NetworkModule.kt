package com.github.core.di.module

import android.os.Environment
import com.github.core.Configs
import com.github.core.data.remote.api.GithubAPI
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkhttpClient(): OkHttpClient {
        val cache = Cache(Environment.getDownloadCacheDirectory(), Configs.Network.CACHE_SIZE)
        return OkHttpClient.Builder()
            .connectTimeout(Configs.Network.TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(Configs.Network.TIME_OUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .cache(cache)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(Configs.Network.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Singleton
    @Provides
    fun provideGithubAPI(retrofit: Retrofit): GithubAPI {
        return retrofit.create(GithubAPI::class.java)
    }
}
