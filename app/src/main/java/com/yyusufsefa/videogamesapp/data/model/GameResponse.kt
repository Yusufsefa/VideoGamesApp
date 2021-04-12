package com.yyusufsefa.videogamesapp.data.model

import com.google.gson.annotations.SerializedName


data class GameResponse(
    var _id: Long,

    val count: Int?,
    val description: String?,
    val filters: Filters?,
    val next: String?,
    val nofollow: Boolean?,
    @SerializedName("nofollow_collections") val nofollowCollections: List<String>?,
    val noindex: Boolean?,
    val previous: String?,
    @SerializedName("results") val games: List<Game>?,
    @SerializedName("seo_description") val seoDescription: String?,
    @SerializedName("seo_h1") val seoH1: String?,
    @SerializedName("seo_keywords") val seoKeywords: String?,
    @SerializedName("seo_title") val seoTitle: String?
)
