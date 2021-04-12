package com.yyusufsefa.videogamesapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShortScreenshot(
    val id: Int?,
    val image: String?
) : Parcelable
