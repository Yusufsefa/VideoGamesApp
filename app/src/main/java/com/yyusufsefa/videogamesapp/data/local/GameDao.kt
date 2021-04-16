package com.yyusufsefa.videogamesapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yyusufsefa.videogamesapp.data.model.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM video_game")
    fun getAllGame(): LiveData<List<Game>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(games: List<Game>)

    @Query("DELETE FROM video_game WHERE _id= :gameId")
    suspend fun deleteLiked(gameId: Int)

    @Query("SELECT * FROM video_game WHERE name LIKE :searchQuery OR slug LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<Game>>

    @Query("UPDATE video_game SET isLiked = :isLiked WHERE _id = :id")
    suspend fun update(isLiked: Boolean, id: Int)

    @Query("SELECT * FROM video_game WHERE _id = :id ")
    fun getGame(id: Int): LiveData<Game>

    @Query("SELECT * FROM video_game WHERE isLiked = 1")
    fun getLikedGame(): LiveData<List<Game>>
}