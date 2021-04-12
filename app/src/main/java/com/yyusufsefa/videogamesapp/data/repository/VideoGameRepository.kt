package com.yyusufsefa.videogamesapp.data.repository

import com.yyusufsefa.videogamesapp.common.BaseRepository
import com.yyusufsefa.videogamesapp.data.model.GameDetailResponse
import com.yyusufsefa.videogamesapp.data.model.GameResponse
import com.yyusufsefa.videogamesapp.network.Api
import com.yyusufsefa.videogamesapp.util.Resource
import javax.inject.Inject

class VideoGameRepository @Inject constructor(private val api: Api) : BaseRepository() {

    suspend fun getVideoGames(): Resource<GameResponse> {
        return getResult {
            api.getVideoGames()
        }
    }

    suspend fun getDetailVideoGames(name: String): Resource<GameDetailResponse> {
        return getResult {
            api.getDetailVideoGames(name)
        }
    }
}