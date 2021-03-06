package com.yyusufsefa.videogamesapp.di

import android.content.Context
import androidx.room.Room
import com.yyusufsefa.videogamesapp.data.local.GameDao
import com.yyusufsefa.videogamesapp.data.local.GameDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DATABASE_NAME = "game_database"

    @Provides
    @Singleton
    fun gameDatabase(@ApplicationContext context: Context): GameDatabase = Room.databaseBuilder(
        context,
        GameDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun gameDao(gameDatabase: GameDatabase): GameDao = gameDatabase.gameDao()
}