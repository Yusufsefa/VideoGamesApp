package com.yyusufsefa.videogamesapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EsrbRating(
    val id: Int?,
    val name: String?,
    val slug: String?
) : Parcelable
