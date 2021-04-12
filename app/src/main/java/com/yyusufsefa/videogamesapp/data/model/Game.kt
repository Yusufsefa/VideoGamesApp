package com.yyusufsefa.videogamesapp.data.model

import com.google.gson.annotations.SerializedName

data class Game(
    val id: Int,
    val added: Int? = null,
    @SerializedName("added_by_status") val addedByStatus: AddedByStatus? = null,
    @SerializedName("background_image") val backgroundImage: String? = null,
    val clip: Clip? = null,
    @SerializedName("dominant_color") val dominantColor: String? = null,
    @SerializedName("esrb_rating") val esrbRating: EsrbRating? = null,
    val genres: List<Genre>? = null,
    val metacritic: Int? = null,
    val name: String? = null,
    @SerializedName("parent_platforms") val parentPlatforms: List<ParentPlatform>? = null,
    val platforms: List<Platform>? = null,
    val playtime: Int? = null,
    val rating: Double? = null,
    @SerializedName("rating_top") val ratingTop: Int? = null,
    val ratings: List<Rating>? = null,
    @SerializedName("ratings_count") val ratingsCount: Int? = null,
    val released: String? = null,
    @SerializedName("reviews_count") val reviewsCount: Int? = null,
    @SerializedName("reviews_text_count") val reviewsTextCount: Int? = null,
    val saturated_color: String? = null,
    @SerializedName("short_screenshots") val shortScreenshots: List<ShortScreenshot>? = null,
    val slug: String? = null,
    val stores: List<Store>? = null,
    @SerializedName("suggestions_count") val suggestionsCount: Int? = null,
    val tags: List<Tag>? = null,
    val tba: Boolean? = null,
    val updated: String? = null,
    @SerializedName("user_game") var userGame: String? = null,
    val isLiked: Boolean
)