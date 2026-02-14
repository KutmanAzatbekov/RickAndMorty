package com.geeks.rickandmorty.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.geeks.rickandmorty.domain.model.CharacterParams
import com.geeks.rickandmorty.domain.usecase.GetCharactersPageSourceUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class CharacterListViewModel(
    private val getCharactersPageSourceUseCase: GetCharactersPageSourceUseCase
): ViewModel() {

    val pagingData =getCharactersPageSourceUseCase(CharacterParams(page = 1))
        .cachedIn(viewModelScope)
        .stateIn(scope = viewModelScope, started = SharingStarted.Lazily, initialValue = PagingData.empty())

}