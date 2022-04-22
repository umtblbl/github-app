package com.github.core.mapper

interface Mapper<F, T> {
    fun map(from: F): T
}
