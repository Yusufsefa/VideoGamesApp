package com.yyusufsefa.videogamesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yyusufsefa.videogamesapp.data.model.Game

@Database(
    entities = [Game::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataTypeConverter::class)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}