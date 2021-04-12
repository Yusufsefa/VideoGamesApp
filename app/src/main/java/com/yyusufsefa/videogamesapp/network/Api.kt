package com.yyusufsefa.videogamesapp.network

import com.yyusufsefa.videogamesapp.data.model.GameDetailResponse
import com.yyusufsefa.videogamesapp.data.model.GameResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("games")
    suspend fun getVideoGames(): Response<GameResponse>

    @GET("games/{name}")
    suspend fun getDetailVideoGames(
        @Path("name") name: String
    ): Response<GameDetailResponse>
}