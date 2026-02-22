package com.geeks.episode.domain.di


import com.geeks.episode.domain.usecase.GetEpisodeByIdUseCase
import com.geeks.episode.domain.usecase.GetEpisodesByIdsUseCase
import com.geeks.episode.domain.usecase.GetEpisodePageSourceUseCase
import com.geeks.episode.domain.usecase.GetEpisodesUseCase
import org.koin.core.module.dsl.factoryOf

import org.koin.dsl.module

val episodeDomainModule = module {
    factoryOf(::GetEpisodesUseCase)
    factoryOf(::GetEpisodeByIdUseCase)
    factoryOf(::GetEpisodesByIdsUseCase)
    factoryOf(::GetEpisodePageSourceUseCase)
}