package com.umbertoemonds.shoebillmania.features.story.domain.model

import com.google.gson.annotations.SerializedName

data class StoryResponse(
    @SerializedName("record")
    val stories: List<Story>,
)

data class Story(
    val id: Int,
    @SerializedName("id_category")
    val idCategory: Int,
    @SerializedName("text_category")
    val textCategory: String,
    val fact: String,
)