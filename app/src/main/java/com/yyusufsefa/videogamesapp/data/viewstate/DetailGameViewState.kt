package com.yyusufsefa.videogamesapp.data.viewstate

import com.yyusufsefa.videogamesapp.data.model.GameDetailResponse

class DetailGameViewState(val detailGame: GameDetailResponse) {

    fun getDetailImageUrl() = detailGame.backgroundImage ?: ""

    fun getDetailName() = detailGame.name ?: ""

    fun getRelease() = detailGame.released ?: ""

    fun getMetacriticRate() = detailGame.metacritic.toString()

    fun getDetailDescription() = detailGame.description ?: ""
}