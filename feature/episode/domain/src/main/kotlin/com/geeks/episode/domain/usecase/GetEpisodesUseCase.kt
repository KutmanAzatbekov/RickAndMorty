package com.geeks.episode.domain.usecase


import com.geeks.episode.domain.model.EpisodeResponse
import com.geeks.episode.domain.repository.EpisodeRepository
import com.geeks.rickandmorty.core.network.model.AppError
import com.geeks.rickandmorty.core.network.model.DataResult


class GetEpisodesUseCase(
    private val repository: EpisodeRepository
) {
    suspend operator fun invoke(page: Int): DataResult<EpisodeResponse, AppError> {
        return repository.getEpisodes(page)
    }
}