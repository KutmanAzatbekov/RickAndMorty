package com.geeks.character.domain.model

import com.geeks.rickandmorty.core.network.util.PagingResponse

data class CharacterResponse(
    val info: Info,
    override val results: List<Character>
) : PagingResponse<Character> {
    override val pages: Int = this.info.pages
}