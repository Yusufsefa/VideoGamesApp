package com.yyusufsefa.videogamesapp.data.repository

import androidx.lifecycle.LiveData
import com.yyusufsefa.videogamesapp.common.BaseRepository
import com.yyusufsefa.videogamesapp.data.local.GameDao
import com.yyusufsefa.videogamesapp.data.model.Game
import com.yyusufsefa.videogamesapp.data.model.GameDetailResponse
import com.yyusufsefa.videogamesapp.data.model.GameResponse
import com.yyusufsefa.videogamesapp.network.Api
import com.yyusufsefa.videogamesapp.util.Resource
import javax.inject.Inject

class VideoGameRepository @Inject constructor(private val api: Api, private val gameDao: GameDao) :
    BaseRepository() {

    val allGameDataDb = gameDao.getAllGame()

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

    suspend fun insertData(games: List<Game>) {
        gameDao.insert(games)
    }

    suspend fun updateData(isLiked: Boolean, gameId: Int) {
        gameDao.update(isLiked, gameId)
    }

    suspend fun deleteLikedGame(gameId: Int) {
        gameDao.deleteLiked(gameId)
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Game>> =
        gameDao.searchDatabase(searchQuery)


    fun getGameDb(id: Int): LiveData<Game> =
        gameDao.getGame(id)

    fun getLikedGameFromDb(): LiveData<List<Game>> =
        gameDao.getLikedGame()
}