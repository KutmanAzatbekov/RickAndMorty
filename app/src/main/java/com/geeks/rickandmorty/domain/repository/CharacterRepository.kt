package com.geeks.rickandmorty.domain.repository

import androidx.paging.PagingData
import com.geeks.rickandmorty.domain.model.CharacterParams
import com.geeks.rickandmorty.domain.model.Info
import com.geeks.rickandmorty.network.model.AppError
import com.geeks.rickandmorty.network.model.DataResult
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacters(params: CharacterParams): Flow<PagingData<Character>>

    suspend fun getCharacterById(characterId: Int): DataResult<Character, AppError>

    suspend fun getCharactersTotalInfo(): DataResult<Info, AppError>

}