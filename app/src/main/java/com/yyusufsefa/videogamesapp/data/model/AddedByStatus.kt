package com.yyusufsefa.videogamesapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AddedByStatus(
    val beaten: Int?,
    val dropped: Int?,
    val owned: Int?,
    val playing: Int?,
    val toplay: Int?,
    val yet: Int?
) : Parcelable