package com.geeks.character.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.geeks.character.data.datasource.CharacterPageSource
import com.geeks.character.data.mapper.toDomain
import com.geeks.character.data.model.CharacterDto
import com.geeks.character.data.model.CharacterResponseDto

import com.geeks.rickandmorty.core.network.model.AppError
import com.geeks.rickandmorty.core.network.model.DataResult
import com.geeks.rickandmorty.core.network.model.map
import com.geeks.rickandmorty.core.network.util.safeGet
import io.ktor.client.HttpClient
import io.ktor.utils.io.ioDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import com.geeks.character.domain.model.Character
import com.geeks.character.domain.model.CharacterParams
import com.geeks.character.domain.model.CharacterResponse
import com.geeks.character.domain.model.Info
import com.geeks.character.domain.repository.CharacterRepository

class RealCharacterRepository(
    private val client: HttpClient
) : CharacterRepository {

    override fun getCharactersPageSours(params: CharacterParams): Flow<PagingData<Character>> =
        Pager(
            config = PagingConfig(pageSize = 20, prefetchDistance = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                CharacterPageSource(requestParams = params) { params ->
                    getCharacters(params)
                }
            }
        ).flow.flowOn(Dispatchers.IO)

    override suspend fun getCharacters(params: CharacterParams): DataResult<CharacterResponse, AppError> =
        client.safeGet<CharacterResponseDto>(url = "character", dispatcher = Dispatchers.IO) {
            url.parameters.apply {
                append("page", params.page.toString())
                params.query?.let { append("name", it) }
                params.status?.let { append("status", it) }
                params.species?.let { append("species", it) }
                params.gender?.let { append("gender", it) }
                params.type?.let { append("type", it) }
            }
        }.map {
            it.toDomain()
        }


    override suspend fun getCharacterById(characterId: Int): DataResult<Character, AppError> =
        client.safeGet<CharacterDto>(url = "character/${characterId}", dispatcher = ioDispatcher())
            .map { it.toDomain() }

    override suspend fun getCharacterByIds(characterIds: List<Int>): DataResult<List<Character>, AppError> =
        client.safeGet<List<CharacterDto>>(url = "character/${
            characterIds.joinToString(separator = ",", prefix = "[", postfix = "]")
        }",
            dispatcher = ioDispatcher()).map { result -> result.map { it.toDomain() } }


    override suspend fun getCharactersTotalInfo(): DataResult<Info, AppError> =
        client.safeGet<CharacterResponseDto>(url = "character?page=1", dispatcher = Dispatchers.IO)
            .map { it.info?.toDomain()
                ?: throw Exception("Не удалось получить информацию о персонажах") }
}