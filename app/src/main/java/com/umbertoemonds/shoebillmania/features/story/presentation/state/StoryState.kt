package com.umbertoemonds.shoebillmania.features.story.presentation.state

import androidx.compose.ui.graphics.Color
import com.umbertoemonds.shoebillmania.R
import com.umbertoemonds.shoebillmania.features.story.domain.model.Story

sealed class StoryState {
    data object Initial: StoryState()
    data class Success(val stories: List<StoryUi>): StoryState()
    data class Error(val t: Throwable): StoryState()
}

data class StoryUi(
    val categoryColor: Color,
    val category: String,
    val story: String,
)

fun Story.toStoryUi() = StoryUi(
    categoryColor = getColorForId(idCategory),
    category = textCategory,
    story = fact,
)

fun getColorForId(id: Int): Color {
    val hue = (id * (360f / 29f)) % 360f
    return Color.hsl(hue, 0.6f, 0.5f)
}

val shoebillImages = listOf(
    R.drawable.shoebill1, R.drawable.shoebill2, R.drawable.shoebill3,
    R.drawable.shoebill4, R.drawable.shoebill5, R.drawable.shoebill6,
    R.drawable.shoebill7, R.drawable.shoebill8, R.drawable.shoebill9,
    R.drawable.shoebill10, R.drawable.shoebill11, R.drawable.shoebill12,
    R.drawable.shoebill13, R.drawable.shoebill14
)