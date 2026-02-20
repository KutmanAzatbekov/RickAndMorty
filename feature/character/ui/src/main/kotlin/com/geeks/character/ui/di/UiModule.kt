package com.geeks.character.ui.di

import com.geeks.character.ui.characters.CharacterListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::CharacterListViewModel)
}