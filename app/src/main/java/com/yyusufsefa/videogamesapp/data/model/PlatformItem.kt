package com.yyusufsefa.videogamesapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class PlatformItem(
    @SerializedName("games_count") val gamesCount: Int?,
    val id: Int?,
    val image: @RawValue Any? = null,
    @SerializedName("image_background") val imageBackground: String?,
    val name: String?,
    val slug: String?,
    @SerializedName("year_end") val yearEnd: @RawValue Any? = null,
    @SerializedName("year_start") val yearStart: @RawValue Any? = null,
    @SerializedName("released_at") val releasedAtt: String?,
    @SerializedName("requirements") val requirements: Requirements?
) : Parcelable
