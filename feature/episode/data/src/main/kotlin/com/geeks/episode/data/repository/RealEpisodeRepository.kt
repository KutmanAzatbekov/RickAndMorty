package com.geeks.episode.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.geeks.episode.data.mapper.toDomain
import com.geeks.episode.data.model.EpisodeDto
import com.geeks.episode.data.model.EpisodeReponseDto
import com.geeks.rickandmorty.core.network.model.AppError
import com.geeks.rickandmorty.core.network.model.DataResult
import com.geeks.rickandmorty.core.network.model.map
import com.geeks.rickandmorty.core.network.util.safeGet
import io.ktor.client.HttpClient
import io.ktor.utils.io.ioDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import com.geeks.episode.domain.model.Episode
import com.geeks.episode.domain.model.EpisodeResponse
import com.geeks.rickandmorty.core.network.util.BasePageSours
import com.geeks.episode.domain.repository.EpisodeRepository


class RealEpisodeRepository(
    private val client: HttpClient
) : EpisodeRepository {

    override fun getEpisodePageSource(page: Int): Flow<PagingData<Episode>> =
        Pager(
            config = PagingConfig(pageSize = 20, prefetchDistance = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                object : BasePageSource<Episode, EpisodeResponse>() {
                    override suspend fun fetchData(page: Int) = getEpisodes(page)
                }
            }
        ).flow.flowOn(Dispatchers.IO)

    override suspend fun getEpisodes(page: Int): DataResult<EpisodeResponse, AppError> =
        client.safeGet<EpisodeReponseDto>(url = "episode", dispatcher = Dispatchers.IO) {
            url.parameters.apply {
                append("page", page.toString())
            }
        }.map {
            it.toDomain()
        }


    override suspend fun getEpisodeById(episodeId: Int): DataResult<Episode, AppError> =
        client.safeGet<EpisodeDto>(url = "character/${episodeId}", dispatcher = ioDispatcher())
            .map { it.toDomain() }


    override suspend fun getEpisodesByIds(episodeIds: List<Int>): DataResult<List<Episode>, AppError> =
        client.safeGet<List<EpisodeDto>>(url = "character/${
            episodeIds.joinToString(separator = ",", prefix = "[", postfix = "]")
        }",
            dispatcher = ioDispatcher()).map { result -> result.map { it.toDomain() } }

}