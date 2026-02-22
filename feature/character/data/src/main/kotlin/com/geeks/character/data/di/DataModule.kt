package com.geeks.character.data.di


import com.geeks.character.data.repository.RealCharacterRepository
import com.geeks.character.domain.repository.CharacterRepository
import org.koin.dsl.module

val characterDataModule = module {
    single<CharacterRepository> { RealCharacterRepository(get()) }
}