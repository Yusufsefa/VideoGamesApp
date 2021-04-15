package com.yyusufsefa.videogamesapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Clip(
    val clip: String?,
    val clips: Clips?,
    val preview: String?,
    val video: String?
) : Parcelable
