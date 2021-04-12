package com.yyusufsefa.videogamesapp.data.model

import com.google.gson.annotations.SerializedName

data class Clips(
    @SerializedName("320") val clip320: String?,
    @SerializedName("640") val clip640: String?,
    val full: String?
)
