package com.geeks.rickandmorty.domain.usecase

import com.geeks.rickandmorty.domain.model.Character
import com.geeks.rickandmorty.domain.repository.CharacterRepository
import com.geeks.rickandmorty.network.model.AppError
import com.geeks.rickandmorty.network.model.DataResult

class GetCharacterByIdUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(characterId: Int): DataResult<Character, AppError> {
        return repository.getCharacterById(characterId)
    }
}