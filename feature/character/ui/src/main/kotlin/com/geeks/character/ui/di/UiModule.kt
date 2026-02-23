package com.geeks.character.ui.di

import com.geeks.character.ui.characters.CharacterListViewModel
import com.geeks.character.ui.characters.detail.CharacterDetailViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val characterUiModule = module {
    viewModelOf(::CharacterListViewModel)
    viewModelOf(::CharacterDetailViewModel)
}