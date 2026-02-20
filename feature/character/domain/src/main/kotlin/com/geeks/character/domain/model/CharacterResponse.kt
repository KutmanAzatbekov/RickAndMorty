package com.geeks.character.domain.model

data class CharacterResponse(
    val info: Info,
    val results: List<Character>
)