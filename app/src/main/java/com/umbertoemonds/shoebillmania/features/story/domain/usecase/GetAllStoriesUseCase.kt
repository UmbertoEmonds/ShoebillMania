package com.umbertoemonds.shoebillmania.features.story.domain.usecase

import com.umbertoemonds.shoebillmania.features.story.domain.model.Story
import com.umbertoemonds.shoebillmania.features.story.domain.repository.StoryRepository
import javax.inject.Inject

class GetAllStoriesUseCase @Inject constructor (
    private val storyRepositoryImpl: StoryRepository
) {
    suspend operator fun invoke(): List<Story> = storyRepositoryImpl.getStories()
}
