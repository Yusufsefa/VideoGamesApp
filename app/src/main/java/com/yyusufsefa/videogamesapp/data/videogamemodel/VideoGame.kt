package com.yyusufsefa.videogamesapp.data.videogamemodel

data class VideoGame(
    val id: Int? = 0,
    val slug: String? = "",
    val name: String? = "",
    val released: String? = "",
    val tba: Boolean? = false,
    val background_image: String? = "",
    val rating: Double? = 0.0,
    val rating_top: Int? = 0,
    val ratings: List<Ratings>? = null,
    val ratings_count: Int? = 0,
    val reviews_text_count: Int? = 0,
    val added: Int? = 0,
    val added_by_status: List<AddedByStatus>? = null,
    val metacritic: Int? = 0,
    val playtime: Int? = 0,
    val suggestions_count: Int? = 0,
    val updated: String? = "",
    val user_game: String? = "",
    val reviews_count: Int? = 0,
    val saturated_color: String? = "",
    val dominant_color: String? = "",
    val platforms: List<Platforms>? = null,
    val parent_platforms: List<ParentPlatforms>? = null,
    val genres: List<Genres>? = null,
    val stores: List<Stores>? = null,
    val clip: Clip? = null,
    val tags: List<Tag>? = null,
    val esrb_rating: EsrbRating? = null,
    val short_screenshots: List<ShortScreenshots>? = null


)