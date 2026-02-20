package com.geeks.character.domain.usecase

import androidx.paging.PagingData
import com.geeks.character.domain.model.Character
import com.geeks.character.domain.model.CharacterParams
import com.geeks.character.domain.repository.CharacterRepository

import kotlinx.coroutines.flow.Flow

class GetCharactersPageSourceUseCase(
    private val repository: CharacterRepository
) {
    operator fun invoke(params: CharacterParams): Flow<PagingData<Character>> {
        return repository.getCharactersPageSours(params)
    }
}