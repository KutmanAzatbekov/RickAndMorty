package com.geeks.rickandmorty.data.mapper

import com.geeks.rickandmorty.data.model.CharacterDto
import com.geeks.rickandmorty.data.model.CharacterLocationDto
import com.geeks.rickandmorty.data.model.CharacterRequest
import com.geeks.rickandmorty.data.model.CharacterResponseDto
import com.geeks.rickandmorty.data.model.InfoDto
import com.geeks.rickandmorty.data.model.OriginDto
import com.geeks.rickandmorty.domain.model.CharacterLocation
import com.geeks.rickandmorty.domain.model.CharacterResponse
import com.geeks.rickandmorty.domain.model.Info
import com.geeks.rickandmorty.domain.model.Origin
import com.geeks.rickandmorty.domain.model.Character
import com.geeks.rickandmorty.domain.model.CharacterParams

fun CharacterResponseDto.toDomain(): CharacterResponse {
    return CharacterResponse(
        info = this.info?.toDomain() ?: Info(count = -1, pages = -1, next = "", prev = ""),
        results = this.results?.map { it.toDomain() } ?: emptyList()
    )
}

fun CharacterDto.toDomain(): Character {
    return Character(
        id = this.id ?: 0,
        name = this.name.orEmpty(),
        status = this.status.orEmpty(),
        species = this.species.orEmpty(),
        type = this.type.orEmpty(),
        gender = this.gender.orEmpty(),
        origin = this.origin?.toDomain() ?: Origin(name = "", url = ""),
        characterLocation = this.characterLocation?.toDomain() ?: CharacterLocation(
            name = "",
            url = ""
        ),
        image = this.image.orEmpty(),
        episode = this.episode.orEmpty(),
        url = this.url.orEmpty(),
        created = this.created.orEmpty()
    )
}

fun OriginDto.toDomain(): Origin {
    return Origin(
        name = this.name.orEmpty(),
        url = this.url.orEmpty()
    )
}

fun CharacterLocationDto.toDomain(): CharacterLocation {
    return CharacterLocation(
        name = name.orEmpty(),
        url = url.orEmpty()
    )
}


fun InfoDto.toDomain(): Info {
    return Info(
        count = this.count ?: 0,
        pages = this.pages ?: 0,
        next = this.next ?: "",
        prev = this.prev ?: ""
    )
}


