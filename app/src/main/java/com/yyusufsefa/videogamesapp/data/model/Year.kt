package com.yyusufsefa.videogamesapp.data.model

data class Year(
    val count: Int?,
    val decade: Int?,
    val filter: String?,
    val from: Int?,
    val nofollow: Boolean?,
    val to: Int?,
    val years: List<Year>?
)
