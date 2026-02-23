package com.geeks.character.ui.core

import com.geeks.rickandmorty.core.network.model.AppError
import com.geeks.rickandmorty.core.network.model.DataResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
sealed interface UiState<out T> {
    data object NotLoaded : UiState<Nothing>
    data object Loading : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
    data class Error(val message: String) : UiState<Nothing>
}

fun <T, E: AppError> DataResult<T, E>.toUiState(): UiState<T> {
    return when (this) {
        is DataResult.Success -> UiState.Success(this.data)
        is DataResult.Error -> UiState.Error(
            message = this.error.asThrowable().message ?: "Неизвестная ошибка"
        )
    }
}