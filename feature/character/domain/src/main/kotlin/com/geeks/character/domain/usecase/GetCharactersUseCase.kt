package com.geeks.character.domain.usecase

import com.geeks.character.domain.model.CharacterParams
import com.geeks.character.domain.model.CharacterResponse
import com.geeks.character.domain.repository.CharacterRepository
import com.geeks.rickandmorty.core.network.model.AppError
import com.geeks.rickandmorty.core.network.model.DataResult


class GetCharactersUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(params: CharacterParams): DataResult<CharacterResponse, AppError> {
        return repository.getCharacters(params)
    }
}