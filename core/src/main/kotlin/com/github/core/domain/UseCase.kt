package com.github.core.domain

abstract class UseCase<out Type : Any?, in Params> {
    abstract suspend operator fun invoke(params: Params? = null): Type

    object None {
        override fun toString() = "UseCase.None"
    }
}
