package com.geeks.character.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.geeks.character.domain.model.CharacterParams
import com.geeks.character.domain.usecase.GetCharactersPageSourceUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class CharacterListViewModel(
    private val getCharactersPageSourceUseCase: GetCharactersPageSourceUseCase
): ViewModel() {

    val pagingData =getCharactersPageSourceUseCase(CharacterParams(page = 1))
        .cachedIn(viewModelScope)
        .stateIn(scope = viewModelScope, started = SharingStarted.Lazily, initialValue = PagingData.empty())

}