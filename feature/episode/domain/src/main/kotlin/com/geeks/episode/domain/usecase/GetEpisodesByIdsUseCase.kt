package com.geeks.episode.domain.usecase


import com.geeks.episode.domain.model.Episode
import com.geeks.episode.domain.repository.EpisodeRepository
import com.geeks.rickandmorty.core.network.model.AppError
import com.geeks.rickandmorty.core.network.model.DataResult

class GetEpisodesByIdsUseCase(
    private val repository: EpisodeRepository
) {
    suspend operator fun invoke(episodeIds: List<Int>): DataResult<List<Episode>, AppError> {
        return repository.getEpisodesByIds(episodeIds)
    }
}