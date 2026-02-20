package com.geeks.character.domain.usecase


import com.geeks.character.domain.model.Character
import com.geeks.character.domain.repository.CharacterRepository
import com.geeks.rickandmorty.core.network.model.AppError
import com.geeks.rickandmorty.core.network.model.DataResult

class GetCharactersByIdsUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(charactersIds: List<Int>): DataResult<List<Character>, AppError> {
        return repository.getCharacterByIds(charactersIds)
    }
}