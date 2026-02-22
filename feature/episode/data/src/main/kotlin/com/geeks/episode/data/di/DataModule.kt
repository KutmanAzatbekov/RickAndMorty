package com.geeks.episode.data.di



import com.geeks.episode.data.repository.RealEpisodeRepository
import com.geeks.episode.domain.repository.EpisodeRepository
import org.koin.dsl.module

val episodeDataModule = module {
    single<EpisodeRepository> { RealEpisodeRepository(get()) }
}