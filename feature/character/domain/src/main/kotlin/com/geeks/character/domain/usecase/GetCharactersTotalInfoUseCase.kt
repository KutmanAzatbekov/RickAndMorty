package com.geeks.character.domain.usecase


import com.geeks.character.domain.model.Info
import com.geeks.character.domain.repository.CharacterRepository
import com.geeks.rickandmorty.core.network.model.AppError
import com.geeks.rickandmorty.core.network.model.DataResult

class GetCharactersTotalInfoUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(): DataResult<Info, AppError> {
        return repository.getCharactersTotalInfo()
    }
}