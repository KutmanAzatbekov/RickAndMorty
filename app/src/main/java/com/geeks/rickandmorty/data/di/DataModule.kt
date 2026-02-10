package com.geeks.rickandmorty.data.di

import com.geeks.rickandmorty.data.repository.RealCharacterRepository
import com.geeks.rickandmorty.domain.repository.CharacterRepository
import org.koin.dsl.module

val dataModule = module {
    single<CharacterRepository> { RealCharacterRepository(get()) }
}