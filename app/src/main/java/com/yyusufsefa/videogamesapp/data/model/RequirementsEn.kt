package com.yyusufsefa.videogamesapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RequirementsEn(
    val minimum: String?,
    val recommended: String?
) : Parcelable
