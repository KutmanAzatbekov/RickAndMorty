package com.geeks.rickandmorty.domain.repository

import androidx.paging.PagingData
import com.geeks.rickandmorty.domain.model.CharacterParams
import com.geeks.rickandmorty.domain.model.Info
import com.geeks.rickandmorty.network.model.AppError
import com.geeks.rickandmorty.network.model.DataResult
import kotlinx.coroutines.flow.Flow
import com.geeks.rickandmorty.domain.model.Character
import com.geeks.rickandmorty.domain.model.CharacterResponse

interface CharacterRepository {

    fun getCharactersPageSours(params: CharacterParams): Flow<PagingData<Character>>
    suspend fun getCharacters(params: CharacterParams): DataResult<CharacterResponse, AppError>

    suspend fun getCharacterById(characterId: Int): DataResult<Character, AppError>
    suspend fun getCharacterByIds(characterIds: List<Int>): DataResult<List<Character>, AppError>

    suspend fun getCharactersTotalInfo(): DataResult<Info, AppError>

}