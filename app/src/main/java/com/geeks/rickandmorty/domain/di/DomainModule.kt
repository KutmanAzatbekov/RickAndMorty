package com.geeks.rickandmorty.domain.di

import com.geeks.rickandmorty.domain.usecase.GetCharacterByIdUseCase
import com.geeks.rickandmorty.domain.usecase.GetCharactersByIdsUseCase
import com.geeks.rickandmorty.domain.usecase.GetCharactersPageSourceUseCase
import com.geeks.rickandmorty.domain.usecase.GetCharactersTotalInfoUseCase
import com.geeks.rickandmorty.domain.usecase.GetCharactersUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetCharactersUseCase)
    factoryOf(::GetCharacterByIdUseCase)
    factoryOf(::GetCharactersByIdsUseCase)
    factoryOf(::GetCharactersPageSourceUseCase)
    factoryOf(::GetCharactersTotalInfoUseCase)
}