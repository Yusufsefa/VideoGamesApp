package com.yyusufsefa.videogamesapp.data.viewstate

import com.yyusufsefa.videogamesapp.data.model.Game

class GameItemViewState(private val game: Game) {

    fun getName() = game.name.orEmpty()

    fun getRatingAndReleased() = "${game.rating}  -  ${game.released}"

    fun getImageUrl() = game.backgroundImage.orEmpty()
}