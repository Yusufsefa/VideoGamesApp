package com.yyusufsefa.videogamesapp.data.viewstate

import com.yyusufsefa.videogamesapp.data.model.Game

class VpItemViewPagerState(private val game: Game) {

    fun getImageUrl() = game.backgroundImage ?: ""
}