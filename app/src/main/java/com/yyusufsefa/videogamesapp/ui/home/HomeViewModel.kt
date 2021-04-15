package com.yyusufsefa.videogamesapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yyusufsefa.videogamesapp.data.model.Game
import com.yyusufsefa.videogamesapp.data.repository.VideoGameRepository
import com.yyusufsefa.videogamesapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val videoGameRepository: VideoGameRepository) :
    ViewModel() {

    private val _gameData = MutableLiveData<Resource<List<Game>>>()
    val gameData: LiveData<Resource<List<Game>>> get() = _gameData

    val allGameFromDb: LiveData<List<Game>> = videoGameRepository.allGameDataDb

    init {
        getVideoGames()
    }


    private fun getVideoGames() {
        viewModelScope.launch {
            _gameData.postValue(Resource.loading())

            videoGameRepository.getVideoGames().let {
                it.data?.let { gameResponse ->
                    _gameData.postValue(Resource.success(gameResponse.games.orEmpty()))
                    videoGameRepository.insertData(gameResponse.games.orEmpty())
                }
            }
        }
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Game>> {
        return videoGameRepository.searchDatabase(searchQuery)
    }

}