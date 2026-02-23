package com.geeks.character.ui.characters.detail
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geeks.character.domain.model.Character
import com.geeks.character.domain.usecase.GetCharacterByIdUseCase
import com.geeks.character.ui.core.UiState
import com.geeks.character.ui.core.toUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
class CharacterDetailViewModel(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<Character>>(UiState.NotLoaded)
    val uiState: StateFlow<UiState<Character>> = _uiState.asStateFlow()

    fun loadData(characterId: Int) {
        viewModelScope.launch {
            _uiState.value = getCharacterByIdUseCase(characterId).toUiState()
        }
    }
}