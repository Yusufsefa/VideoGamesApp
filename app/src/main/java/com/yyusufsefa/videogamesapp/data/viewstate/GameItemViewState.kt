package com.yyusufsefa.videogamesapp.data.viewstate

import com.yyusufsefa.videogamesapp.data.model.Game

class GameItemViewState(
    val game: Game
) {
    fun getName() = game.name ?: ""

    fun getRatingAndReleased() = "${game.rating}  -  ${game.released}"

    fun getImageUrl() = game.backgroundImage ?: ""
}