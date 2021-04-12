package com.yyusufsefa.videogamesapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ParentPlatform(
    val platformItem: PlatformItem?
) : Parcelable
