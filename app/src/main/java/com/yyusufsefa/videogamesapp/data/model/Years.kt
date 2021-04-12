package com.yyusufsefa.videogamesapp.data.model

data class Years(
    val from: Int? = 0,
    val to: Int? = 0,
    val filter: String? = "",
    val decade: Int? = 0,
    val years: List<_Years>? = null,
    val nofollow: Boolean? = false,
    val count: Int? = 0
)