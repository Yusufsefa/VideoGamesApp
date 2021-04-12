package com.yyusufsefa.videogamesapp.data.model

data class VideoGameResponse(
    val WARNING: String? = "",
    val count: Int? = 0,
    val next: String? = "",
    val previous: String? = "",
    val result: List<VideoGame>? = null,
    val seo_title: String? = "",
    val seo_description: String? = "",
    val seo_keywords: String? = "",
    val seo_h1: String? = "",
    val noindex: Boolean? = false,
    val nofollow: Boolean? = false,
    val filters: Filters? = null,
    val nofollow_collections: List<String>? = null
)