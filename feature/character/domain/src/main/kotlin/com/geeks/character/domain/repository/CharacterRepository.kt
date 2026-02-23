package com.geeks.character.domain.repository


import androidx.paging.PagingData
import com.geeks.character.domain.model.CharacterParams
import com.geeks.character.domain.model.CharacterResponse
import com.geeks.character.domain.model.Info
import com.geeks.rickandmorty.core.network.model.AppError
import com.geeks.rickandmorty.core.network.model.DataResult
import com.geeks.character.domain.model.Character
import kotlinx.coroutines.flow.Flow


interface CharacterRepository {

    fun getCharactersPageSours(params: CharacterParams): Flow<PagingData<Character>>
    suspend fun getCharacters(params: CharacterParams): DataResult<CharacterResponse, AppError>

    suspend fun getCharacterById(characterId: Int): DataResult<Character, AppError>
    suspend fun getCharactersByIds(characterIds: List<Int>): DataResult<List<Character>, AppError>

    suspend fun getCharactersTotalInfo(): DataResult<Info, AppError>

}