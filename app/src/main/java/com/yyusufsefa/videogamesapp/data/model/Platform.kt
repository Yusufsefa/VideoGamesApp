package com.yyusufsefa.videogamesapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Platform(
    val platformItem: PlatformItem?,
    @SerializedName("released_at") val released_at: String?,
    @SerializedName("requirements_en") val requirementsEn: RequirementsEn?,
    @SerializedName("requirements_ru") val requirementsRu: @RawValue Any? = null
) : Parcelable
