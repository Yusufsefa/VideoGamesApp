package com.yyusufsefa.videogamesapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StoreItem(
    val domain: String?,
    @SerializedName("games_count") val gamesCount: Int?,
    val id: Int?,
    @SerializedName("image_background") val imageBackground: String?,
    val name: String?,
    val slug: String?
) : Parcelable
