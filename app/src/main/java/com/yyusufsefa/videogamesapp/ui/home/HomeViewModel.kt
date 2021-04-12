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

    init {
        getVideoGames()
    }

    fun getVideoGames() {
        viewModelScope.launch {
            _gameData.postValue(Resource.loading())

            videoGameRepository.getVideoGames().let {
                _gameData.postValue(Resource.success(it.data?.games.orEmpty()))
            }
        }
    }


}