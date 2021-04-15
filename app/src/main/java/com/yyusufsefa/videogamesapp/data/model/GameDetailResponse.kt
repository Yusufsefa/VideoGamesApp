package com.yyusufsefa.videogamesapp.data.model

import com.google.gson.annotations.SerializedName

data class GameDetailResponse(
    @SerializedName("achievements_count") val achievementsCount: Int?,
    val added: Int?,
    @SerializedName("added_by_status") val addedByStatus: AddedByStatus?,
    @SerializedName("additions_count") val additionsCount: Int?,
    @SerializedName("alternative_names") val alternativeNames: List<String>?,
    @SerializedName("background_image") val backgroundImage: String?,
    @SerializedName("background_image_additional") val backgroundImageAdditional: String?,
    val clip: Clip?,
    @SerializedName("creators_count") val creatorsCount: Int?,
    val description: String?,
    @SerializedName("description_raw") val descriptionRaw: String?,
    val developers: List<Developer>?,
    @SerializedName("dominant_color") val dominantColor: String?,
    @SerializedName("esrb_rating") val esrbRating: EsrbRating?,
    @SerializedName("game_series_count") val gameSeriesCount: Int?,
    val genres: List<Genre>?,
    val id: Int?,
    val metacritic: Int?,
    @SerializedName("metacritic_platforms") val metacriticPlatforms: List<Any>?,
    @SerializedName("metacritic_url") val metacriticUrl: String?,
    @SerializedName("movies_count") val moviesCount: Int?,
    val name: String?,
    @SerializedName("name_original") val nameOriginal: String?,
    @SerializedName("parent_achievements_count") val parentAchievementsCount: Int?,
    @SerializedName("parent_platforms") val parentPlatforms: List<ParentPlatform>?,
    @SerializedName("parents_count") val parentsCount: Int?,
    val platforms: List<Platform>?,
    val playtime: Int?,
    val publishers: List<Publisher>?,
    val rating: Double?,
    @SerializedName("rating_top") val ratingTop: Int?,
    val ratings: List<Rating>?,
    @SerializedName("ratings_count") val ratingsCount: Int?,
    @SerializedName("reddit_count") val redditCount: Int?,
    @SerializedName("reddit_description") val redditDescription: String?,
    @SerializedName("reddit_logo") val redditLogo: String?,
    @SerializedName("reddit_name") val redditName: String?,
    @SerializedName("reddit_url") val redditUrl: String?,
    val released: String?,
    @SerializedName("reviews_count") val reviewsCount: Int?,
    @SerializedName("reviews_text_count") val reviewsTextCount: Int?,
    @SerializedName("saturated_color") val saturatedColor: String?,
    @SerializedName("screenshots_count") val screenshotsCount: Int?,
    val slug: String?,
    val stores: List<Store>?,
    @SerializedName("suggestions_count") val suggestionsCount: Int?,
    val tags: List<Tag>?,
    val tba: Boolean?,
    @SerializedName("twitch_count") val twitchCount: Int?,
    val updated: String?,
    @SerializedName("user_game") val userGame: String?,
    val website: String?,
    @SerializedName("youtube_count") val youtubeCount: Int?
)