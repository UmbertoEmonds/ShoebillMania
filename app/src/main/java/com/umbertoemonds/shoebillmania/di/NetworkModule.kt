package com.umbertoemonds.shoebillmania.di

import com.umbertoemonds.shoebillmania.features.story.data.datasource.StoryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://api.jsonbin.io/v3/b/"

    @Provides
    @Singleton
    fun provideStoryApi(): StoryService {
        val interceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()

                // The keys are intentionally visible
                .addHeader("X-Access-Key", "\$2a\$10\$zwHGI92vYnsq4oq8./wTUe8JqLCnqOKW8.2Bfk0lXaaDSU6WX3TF6")
                .addHeader("X-Master-Key", "\$2a\$10\$XtpXwiuNwKyUqpAb3YW8/eom6n0ytlGEa96HB290ACwD/cBV1mSUm")
                .build()

            chain.proceed(request)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StoryService::class.java)
    }
}