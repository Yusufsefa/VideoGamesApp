package com.yyusufsefa.videogamesapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Clips(
    @SerializedName("320") val clip320: String?,
    @SerializedName("640") val clip640: String?,
    val full: String?
) : Parcelable
