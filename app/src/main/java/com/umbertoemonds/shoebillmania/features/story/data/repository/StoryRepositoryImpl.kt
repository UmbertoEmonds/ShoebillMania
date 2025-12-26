package com.umbertoemonds.shoebillmania.features.story.data.repository

import com.umbertoemonds.shoebillmania.features.story.data.datasource.StoryService
import com.umbertoemonds.shoebillmania.features.story.domain.repository.StoryRepository
import javax.inject.Inject

class StoryRepositoryImpl @Inject constructor(
    private val service: StoryService
) : StoryRepository {
    override suspend fun getStories() = service.getStories().stories
}