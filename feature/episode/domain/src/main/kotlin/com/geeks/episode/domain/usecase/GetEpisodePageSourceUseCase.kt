package com.geeks.episode.domain.usecase

import androidx.paging.PagingData
import com.geeks.episode.domain.model.Episode
import com.geeks.episode.domain.repository.EpisodeRepository


import kotlinx.coroutines.flow.Flow

class GetEpisodePageSourceUseCase(
    private val repository: EpisodeRepository
) {
    operator fun invoke(page: Int): Flow<PagingData<Episode>> {
        return repository.getEpisodePageSource(page)
    }
}