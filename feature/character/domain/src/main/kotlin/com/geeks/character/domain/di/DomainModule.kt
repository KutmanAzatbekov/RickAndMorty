package com.geeks.character.domain.di


import com.geeks.character.domain.usecase.GetCharacterByIdUseCase
import com.geeks.character.domain.usecase.GetCharactersByIdsUseCase
import com.geeks.character.domain.usecase.GetCharactersPageSourceUseCase
import com.geeks.character.domain.usecase.GetCharactersTotalInfoUseCase
import com.geeks.character.domain.usecase.GetCharactersUseCase
import org.koin.core.module.dsl.factoryOf

import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetCharactersUseCase)
    factoryOf(::GetCharacterByIdUseCase)
    factoryOf(::GetCharactersByIdsUseCase)
    factoryOf(::GetCharactersPageSourceUseCase)
    factoryOf(::GetCharactersTotalInfoUseCase)
}