package com.yyusufsefa.videogamesapp.data.model

import com.google.gson.annotations.SerializedName

data class Developer(
    val games_count: Int?,
    val id: Int?,
    @SerializedName("image_background") val imageBackground: String?,
    val name: String?,
    val slug: String?
)
