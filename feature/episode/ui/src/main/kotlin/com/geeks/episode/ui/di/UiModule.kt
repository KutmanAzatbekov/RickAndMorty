package com.geeks.episode.ui.di

import com.geeks.episode.ui.episodes.EpisodeListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val episodeUiModule = module {
    viewModelOf(::EpisodeListViewModel)
}