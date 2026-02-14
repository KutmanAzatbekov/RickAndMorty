package com.geeks.rickandmorty.ui.di

import com.geeks.rickandmorty.ui.screens.characters.CharacterListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::CharacterListViewModel)
}