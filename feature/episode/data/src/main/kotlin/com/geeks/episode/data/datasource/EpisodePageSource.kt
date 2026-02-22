package com.geeks.episode.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.geeks.episode.domain.model.Episode
import com.geeks.episode.domain.model.EpisodeResponse

import com.geeks.rickandmorty.core.network.model.AppError
import com.geeks.rickandmorty.core.network.model.DataResult


const val START_INDEX = 1

class CharacterPageSource(
    private val page: Int,
    private val request: suspend (Int) -> DataResult<EpisodeResponse, AppError>,
) : PagingSource<Int, Episode>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Episode> {
        val currentPage = params.key ?: START_INDEX

        return when (val result = request(page)) {
            is DataResult.Success -> {
                val episodes = result.data.results
                val pages = result.data.info.pages

                LoadResult.Page(
                    data = episodes,
                    prevKey = if (page == START_INDEX) null else page - 1,
                    nextKey = if (episodes.isEmpty() || currentPage >= pages) null else page + 1
                )
            }
            is DataResult.Error -> {
                val throwable = if (result.error is AppError.Api.TooManyRequests) {
                    (result.error as AppError.Api.TooManyRequests).copy(message = "Ты плохой и больше данных мы тебе не дадим").asThrowable()
                } else {
                    result.error.asThrowable()
                }
                LoadResult.Error(throwable)
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Episode>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}