package com.geeks.rickandmorty.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.geeks.rickandmorty.data.model.CharacterRequest
import com.geeks.rickandmorty.data.repository.RealCharacterRepository
import com.geeks.rickandmorty.domain.model.CharacterParams
import com.geeks.rickandmorty.domain.model.CharacterResponse
import com.geeks.rickandmorty.domain.repository.CharacterRepository
import com.geeks.rickandmorty.network.model.AppError
import com.geeks.rickandmorty.network.model.DataResult
import com.geeks.rickandmorty.network.model.onError
import com.geeks.rickandmorty.network.model.onSuccess
import com.geeks.rickandmorty.domain.model.Character

const val START_INDEX = 1

class CharacterPageSource(
    private val requestParams: CharacterParams,
    private val request: suspend (CharacterParams) -> DataResult<CharacterResponse, AppError>,
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val page = params.key ?: START_INDEX

        return when (val result = request(requestParams.copy(page = page))) {
            is DataResult.Success -> {
                val characters = result.data.results

                LoadResult.Page(
                    data = characters,
                    prevKey = if (page == START_INDEX) null else page - 1,
                    nextKey = if (characters.isEmpty() || result.data.info.next == null) null else page + 1
                )
            }
            is DataResult.Error -> {
                val throwable = if (result.error is AppError.Api.TooManyRequests) {
                    result.error.copy(message = "Ты плохой и больше данных мы тебе не дадим").asThrowable()
                } else {
                    result.error.asThrowable()
                }
                LoadResult.Error(throwable)
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}