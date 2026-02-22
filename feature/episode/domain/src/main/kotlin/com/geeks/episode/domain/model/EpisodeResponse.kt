package com.geeks.episode.domain.model

import com.geeks.rickandmorty.core.network.util.PagingResponse


data class EpisodeResponse(
    val info: Info,
    override val results: List<Episode>
) : PagingResponse<Episode> {
    override val pages: Int get() = info.pages
}
