package com.geeks.rickandmorty.domain.usecase

import com.geeks.rickandmorty.domain.model.Character
import com.geeks.rickandmorty.domain.repository.CharacterRepository
import com.geeks.rickandmorty.network.model.AppError
import com.geeks.rickandmorty.network.model.DataResult

class GetCharactersByIdsUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(charactersIds: List<Int>): DataResult<List<Character>, AppError> {
        return repository.getCharacterByIds(charactersIds)
    }
}