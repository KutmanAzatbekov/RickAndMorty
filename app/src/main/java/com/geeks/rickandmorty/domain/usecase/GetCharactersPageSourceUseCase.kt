package com.geeks.rickandmorty.domain.usecase

import androidx.paging.PagingData
import com.geeks.rickandmorty.domain.model.Character
import com.geeks.rickandmorty.domain.model.CharacterParams
import com.geeks.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetCharactersPageSourceUseCase(
    private val repository: CharacterRepository
) {
    operator fun invoke(params: CharacterParams): Flow<PagingData<Character>> {
        return repository.getCharactersPageSours(params)
    }
}