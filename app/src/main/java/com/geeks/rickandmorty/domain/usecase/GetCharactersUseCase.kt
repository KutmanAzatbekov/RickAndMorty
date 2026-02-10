package com.geeks.rickandmorty.domain.usecase

import com.geeks.rickandmorty.domain.model.CharacterParams
import com.geeks.rickandmorty.domain.model.CharacterResponse
import com.geeks.rickandmorty.domain.repository.CharacterRepository
import com.geeks.rickandmorty.network.model.AppError
import com.geeks.rickandmorty.network.model.DataResult


class GetCharactersUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(params: CharacterParams): DataResult<CharacterResponse, AppError> {
        return repository.getCharacters(params)
    }
}