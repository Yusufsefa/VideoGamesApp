package com.yyusufsefa.videogamesapp.ui.favori

import androidx.lifecycle.ViewModel
import com.yyusufsefa.videogamesapp.data.repository.VideoGameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriViewModel @Inject constructor(private val repository: VideoGameRepository) :
    ViewModel() {

    val allLikedGame = repository.getLikedGameFromDb()
}