package com.geeks.rickandmorty.core.network.model

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppError{

    sealed interface Network : AppError{
        @Serializable data object NoInternet: Network
        @Serializable data object Timeout: Network
        @Serializable data object ServerUnavailable: Network
        @Serializable data object Serialization: Network
        @Serializable data class Unknown(val message: String): Network
    }

    sealed interface Api : AppError{
        @Serializable data class Unauthorized(val message: String) : Api
        @Serializable data class Forbidden(val message: String) : Api
        @Serializable data class NotFound(val message: String) : Api
        @Serializable data class Conflict(val message: String) : Api

        @Serializable data class TooManyRequests(val message: String): Api
        @Serializable data class BadRequest(val message: String) : Api
        @Serializable data class ServerError(val code: Int, val message: String?) : Api
    }

    @Serializable data class Unknown(val message: String?): AppError


    fun asThrowable(): Throwable = when (this) {
        is Network.NoInternet -> kotlinx.io.IOException("Отсутствует интернет")
        is Api.NotFound -> NoSuchElementException(this.message)
        is Api.BadRequest -> IllegalArgumentException(this.message)
        else -> Exception(this.toString())
    }
}