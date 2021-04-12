package com.yyusufsefa.videogamesapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rating(
    val count: Int?,
    val id: Int?,
    val percent: Double?,
    val title: String?
) : Parcelable
