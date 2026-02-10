package com.geeks.rickandmorty.domain.usecase

import com.geeks.rickandmorty.domain.model.Info
import com.geeks.rickandmorty.domain.repository.CharacterRepository
import com.geeks.rickandmorty.network.model.AppError
import com.geeks.rickandmorty.network.model.DataResult

class GetCharactersTotalInfoUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(): DataResult<Info, AppError> {
        return repository.getCharactersTotalInfo()
    }
}