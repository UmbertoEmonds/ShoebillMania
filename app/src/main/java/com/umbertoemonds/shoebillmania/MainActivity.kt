package com.umbertoemonds.shoebillmania

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.umbertoemonds.shoebillmania.features.story.presentation.composable.ShoebillScreen
import com.umbertoemonds.shoebillmania.features.story.presentation.state.StoryState
import com.umbertoemonds.shoebillmania.features.story.presentation.viewmodel.StoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: StoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            enableEdgeToEdge()

            viewModel.getStories()
            val storyState = viewModel.stories.collectAsState()

            when(val state = storyState.value){
                is StoryState.Success -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0x00E0D3B4)),
                        verticalArrangement = Arrangement.Center
                    ) {
                        ShoebillScreen(state.stories.shuffled().toMutableList())
                    }
                }
                is StoryState.Error -> {}
                else -> {}
            }
        }
    }
}