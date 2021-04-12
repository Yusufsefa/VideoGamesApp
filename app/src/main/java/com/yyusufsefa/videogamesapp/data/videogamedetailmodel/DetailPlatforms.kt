package com.yyusufsefa.videogamesapp.data.videogamedetailmodel

import com.yyusufsefa.videogamesapp.data.videogamemodel._Platform

data class DetailPlatforms(
    val platform: List<_Platform>? = null,
    val released_at: String? = "",
    val requirements: Requirements? = null
)
