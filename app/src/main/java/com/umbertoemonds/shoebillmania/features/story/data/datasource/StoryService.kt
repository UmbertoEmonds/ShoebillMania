package com.umbertoemonds.shoebillmania.features.story.data.datasource

import com.umbertoemonds.shoebillmania.features.story.domain.model.StoryResponse
import retrofit2.http.GET

interface StoryService {
    @GET("694a8f24d0ea881f403ba367")
    suspend fun getStories(): StoryResponse
}