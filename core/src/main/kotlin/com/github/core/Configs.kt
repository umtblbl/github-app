package com.github.core


object Configs {
    object Network {
        const val baseURL: String = BuildConfig.GITHUB_API_BASE_URL
        const val timeOut: Long = 3 * 60
        const val cacheSize: Long = 10 * 1024 * 1024 // 10 MiB
    }

    object Database {
        const val name = BuildConfig.GITHUB_DATABASE_NAME
    }
}
