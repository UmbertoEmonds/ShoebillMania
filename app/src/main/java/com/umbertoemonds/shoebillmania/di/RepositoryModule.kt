package com.umbertoemonds.shoebillmania.di

import com.umbertoemonds.shoebillmania.features.story.data.repository.StoryRepositoryImpl
import com.umbertoemonds.shoebillmania.features.story.domain.repository.StoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindStoryRepository(
        storyRepositoryImpl: StoryRepositoryImpl
    ): StoryRepository
}