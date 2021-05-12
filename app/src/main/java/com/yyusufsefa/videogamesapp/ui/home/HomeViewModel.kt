package com.yyusufsefa.videogamesapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yyusufsefa.videogamesapp.data.model.Game
import com.yyusufsefa.videogamesapp.data.repository.VideoGameRepository
import com.yyusufsefa.videogamesapp.util.Resource
import com.yyusufsefa.videogamesapp.util.wrapper.SearchStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@FlowPreview
@HiltViewModel
class HomeViewModel @Inject constructor(private val videoGameRepository: VideoGameRepository) :
    ViewModel() {

    private val _gameData = MutableLiveData<Resource<List<Game>>>()
    val gameData: LiveData<Resource<List<Game>>> get() = _gameData

    private val _searchGame = MutableStateFlow<SearchStatus<List<Game>>>(SearchStatus.Idle)
    val searchGame: StateFlow<SearchStatus<List<Game>>> get() = _searchGame.asStateFlow()

    init {
        getVideoGames()
    }

    private fun getVideoGames() {
        viewModelScope.launch {
            _gameData.postValue(Resource.loading())
            _gameData.postValue(Resource.success(videoGameRepository.getAllGame()))
//            videoGameRepository.getVideoGames().let {
//                it.data?.let { gameResponse ->
//                    _gameData.postValue(Resource.success(gameResponse.games.orEmpty()))
//                    videoGameRepository.insertData(gameResponse.games.orEmpty())
//                }
//            }
        }
    }

    private fun searchDatabase(searchQuery: String): Flow<List<Game>> {
        return videoGameRepository.searchDatabase(searchQuery)
    }

    private val queryText = MutableStateFlow("")

    fun searchGame(query: String?) {
        viewModelScope.launch {
            queryText.emit(query.orEmpty())
        }
    }

    init {
        viewModelScope.launch {
            queryText.debounce(300L)
                .filter { query ->
                    if (query.length < 3) {
                        _searchGame.emit(SearchStatus.Idle)
                        return@filter false
                    }
                    return@filter true
                }
                .distinctUntilChanged()
                .flatMapLatest { searchDatabase(it) }
                .flowOn(Dispatchers.Default)
                .catch { _searchGame.emit(SearchStatus.Error(it.cause as Exception)) }
                .collect {
                    if (it.isNotEmpty()) {
                        _searchGame.emit(SearchStatus.Success(it))
                    } else {
                        _searchGame.emit(SearchStatus.Empty)
                    }
                }
        }
    }
}
