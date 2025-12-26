package com.umbertoemonds.shoebillmania.features.story.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umbertoemonds.shoebillmania.features.story.domain.usecase.GetAllStoriesUseCase
import com.umbertoemonds.shoebillmania.features.story.presentation.state.StoryState
import com.umbertoemonds.shoebillmania.features.story.presentation.state.toStoryUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoryViewModel @Inject constructor (
    private val getAllStoriesUseCase: GetAllStoriesUseCase
) : ViewModel() {

    private val _stories = MutableStateFlow<StoryState>(StoryState.Initial)
    val stories = _stories.asStateFlow()

    fun getStories(){
        viewModelScope.launch {
            runCatching {
                val stories = getAllStoriesUseCase()
                _stories.value = StoryState.Success(
                    stories.map {
                        it.toStoryUi()
                    }
                )
            }.onFailure { error ->
                _stories.value = StoryState.Error(error)
            }
        }
    }
}