package com.yyusufsefa.videogamesapp.data.viewstate

import android.content.Context
import androidx.core.content.ContextCompat
import com.yyusufsefa.videogamesapp.R
import com.yyusufsefa.videogamesapp.data.model.Game
import com.yyusufsefa.videogamesapp.data.model.GameDetailResponse

class DetailGameViewState(
    private val detailGame: GameDetailResponse,
    private val game: Game
) {

    fun getDetailImageUrl() = detailGame.backgroundImage.orEmpty()

    fun getDetailName() = detailGame.name.orEmpty()

    fun getRelease() = detailGame.released.orEmpty()

    fun getMetacriticRate() = detailGame.metacritic.toString()

    fun getDetailDescription() = detailGame.description.orEmpty()

    fun checkLike(context: Context): Int {
        val color = if (game.isLiked) R.color.black else R.color.white
        return ContextCompat.getColor(context, color)
    }
}