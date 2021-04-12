package com.yyusufsefa.videogamesapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Store(
    val id: Int?,
    val store: StoreItem?,
    val url: String?
) : Parcelable
