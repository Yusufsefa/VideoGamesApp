package com.yyusufsefa.videogamesapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yyusufsefa.videogamesapp.data.model.GameDetailResponse
import com.yyusufsefa.videogamesapp.data.repository.VideoGameRepository
import com.yyusufsefa.videogamesapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: VideoGameRepository) :
    ViewModel() {

    private val _gameDetail = MutableLiveData<Resource<GameDetailResponse>>()
    val gameDetail: LiveData<Resource<GameDetailResponse>> get() = _gameDetail

    fun getGameDetail(name: String) {
        viewModelScope.launch {
            _gameDetail.postValue(Resource.loading())

            repository.getDetailVideoGames(name).let {
                _gameDetail.postValue(Resource.success(it.data!!))
            }
        }
    }

    fun updateGame(isLiked: Boolean, gameId: Int) {
        viewModelScope.launch {
            repository.updateData(isLiked, gameId)
        }
    }
}