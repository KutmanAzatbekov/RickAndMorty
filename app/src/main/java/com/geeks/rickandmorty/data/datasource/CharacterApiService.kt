package com.geeks.rickandmorty.data.datasource

import com.geeks.rickandmorty.data.model.CharacterRequest
import com.geeks.rickandmorty.data.model.CharacterResponseDto
import com.geeks.rickandmorty.domain.model.CharacterResponse
import com.geeks.rickandmorty.network.model.AppError
import com.geeks.rickandmorty.network.model.DataResult
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers

class CharacterApiService(
    private val client: HttpClient
) {

    suspend fun getCharacters(request: CharacterRequest): DataResult<CharacterResponse, AppError> =

        client.safeGet<CharacterResponseDto>(url = "character", dispatcher = Dispatchers.IO) {
            url.parameters.apply {
                append("page", request.page.toString())
                request.query?.let { append("name", it) }
                request.status?.let { append("status", it) }
                request.species?.let { append("species", it) }
                request.gender?.let { append("gender", it) }
                request.type?.let { append("type", it) }
            }
        }.map {
            it.toDomain()
        }


}