package com.yyusufsefa.videogamesapp.data.model

import com.google.gson.annotations.SerializedName

data class Clips(
    @SerializedName("320")
    val _320: String? = "",
    @SerializedName("640")
    val _640: String? = "",
    val full: String? = ""
)
