package com.github.core.mapper

interface Mapper<F, T> {
    suspend fun map(from: F): T
}
