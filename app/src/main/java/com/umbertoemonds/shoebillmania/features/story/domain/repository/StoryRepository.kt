package com.umbertoemonds.shoebillmania.features.story.domain.repository

import com.umbertoemonds.shoebillmania.features.story.domain.model.Story

interface StoryRepository {
    suspend fun getStories(): List<Story>
}