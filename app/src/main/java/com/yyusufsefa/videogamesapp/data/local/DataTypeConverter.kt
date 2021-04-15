package com.yyusufsefa.videogamesapp.data.local

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yyusufsefa.videogamesapp.data.model.*
import java.lang.reflect.Type

object DataTypeConverter {

    @androidx.room.TypeConverter
    @JvmStatic
    fun addedByStatusToString(item: AddedByStatus?) = Gson().toJson(item)

    @androidx.room.TypeConverter
    @JvmStatic
    fun stringToAddedByStatus(value: String?): AddedByStatus? {
        if (value == null) {
            return null
        }
        val type: Type = object : TypeToken<AddedByStatus?>() {}.type
        return Gson().fromJson<AddedByStatus?>(value, type)
    }

    @androidx.room.TypeConverter
    @JvmStatic
    fun esrbRatingToString(item: EsrbRating?) = Gson().toJson(item)

    @androidx.room.TypeConverter
    @JvmStatic
    fun stringToEsrbRating(value: String?): EsrbRating? {
        if (value == null) {
            return null
        }
        val type: Type = object : TypeToken<EsrbRating?>() {}.type
        return Gson().fromJson<EsrbRating?>(value, type)
    }

    @androidx.room.TypeConverter
    @JvmStatic
    fun listGenreToString(array: List<Genre>) =
        if (array.isEmpty()) "" else Gson().toJson(array)

    @androidx.room.TypeConverter
    @JvmStatic
    fun stringToListGenre(value: String?): List<Genre>? {
        if (value == null) {
            return null
        }
        val listType = object : TypeToken<List<Genre>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @androidx.room.TypeConverter
    @JvmStatic
    fun listParentPlatformToString(array: List<ParentPlatform>) =
        if (array.isEmpty()) "" else Gson().toJson(array)

    @androidx.room.TypeConverter
    @JvmStatic
    fun stringToListParentPlatforms(value: String?): List<ParentPlatform>? {
        if (value == null) {
            return null
        }
        val listType = object : TypeToken<List<ParentPlatform>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @androidx.room.TypeConverter
    @JvmStatic
    fun listPlatformToString(array: List<Platform>) =
        if (array.isEmpty()) "" else Gson().toJson(array)

    @androidx.room.TypeConverter
    @JvmStatic
    fun stringToListPlatforms(value: String?): List<Platform>? {
        if (value == null) {
            return null
        }
        val listType = object : TypeToken<List<Platform>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @androidx.room.TypeConverter
    @JvmStatic
    fun listShortScreenshotToString(array: List<ShortScreenshot>) =
        if (array.isEmpty()) "" else Gson().toJson(array)

    @androidx.room.TypeConverter
    @JvmStatic
    fun stringToListShortScreenshot(value: String?): List<ShortScreenshot>? {
        if (value == null) {
            return null
        }
        val listType = object : TypeToken<List<ShortScreenshot>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @androidx.room.TypeConverter
    @JvmStatic
    fun listStoreToString(array: List<Store>) =
        if (array.isEmpty()) "" else Gson().toJson(array)

    @androidx.room.TypeConverter
    @JvmStatic
    fun stringToListStore(value: String?): List<Store>? {
        if (value == null) {
            return null
        }
        val listType = object : TypeToken<List<Store>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @androidx.room.TypeConverter
    @JvmStatic
    fun listTagToString(array: List<Tag>) =
        if (array.isEmpty()) "" else Gson().toJson(array)

    @androidx.room.TypeConverter
    @JvmStatic
    fun stringToListTag(value: String?): List<Tag>? {
        if (value == null) {
            return null
        }
        val listType = object : TypeToken<List<Tag>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @androidx.room.TypeConverter
    @JvmStatic
    fun listRatingToString(array: List<Rating>) =
        if (array.isEmpty()) "" else Gson().toJson(array)

    @androidx.room.TypeConverter
    @JvmStatic
    fun stringToListRating(value: String?): List<Rating>? {
        if (value == null) {
            return null
        }
        val listType = object : TypeToken<List<Rating>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @androidx.room.TypeConverter
    @JvmStatic
    fun clipToString(item: Clip) = Gson().toJson(item)

    @androidx.room.TypeConverter
    @JvmStatic
    fun stringToClip(value: String?): Clip? {
        if (value == null) {
            return null
        }
        val type: Type = object : TypeToken<Clip?>() {}.type
        return Gson().fromJson<Clip?>(value, type)
    }

}