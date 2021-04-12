package com.yyusufsefa.videogamesapp.data.videogamedetailmodel

import com.yyusufsefa.videogamesapp.data.videogamemodel.Store

data class DetailStore(
    val id: Int? = 0,
    val url: String? = "",
    val store: List<Store>? = null
)
