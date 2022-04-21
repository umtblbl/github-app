package com.github.core


object Configs {
    object Network {
        const val BASE_URL: String = BuildConfig.GITHUB_API_BASE_URL
        const val TIME_OUT: Long = 3 * 60
        const val CACHE_SIZE: Long = 10 * 1024 * 1024 // 10 MiB
    }

    object Database {
        const val NAME = BuildConfig.GITHUB_DATABASE_NAME
    }
}
