package com.geeks.episode.domain.repository


import androidx.paging.PagingData
import com.geeks.episode.domain.model.Episode
import com.geeks.episode.domain.model.EpisodeResponse
import com.geeks.rickandmorty.core.network.model.AppError
import com.geeks.rickandmorty.core.network.model.DataResult
import kotlinx.coroutines.flow.Flow


interface EpisodeRepository {
    fun getEpisodePageSource(page: Int): Flow<PagingData<Episode>>

    suspend fun getEpisodes(page: Int): DataResult<EpisodeResponse, AppError>

    suspend fun getEpisodeById(episodeId: Int): DataResult<Episode, AppError>

    suspend fun getEpisodesByIds(episodeIds: List<Int>): DataResult<List<Episode>, AppError>
}