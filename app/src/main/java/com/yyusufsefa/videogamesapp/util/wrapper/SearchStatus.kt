package com.yyusufsefa.videogamesapp.util.wrapper

sealed class SearchStatus<out T> {
    data class Success<T>(val list: T) : SearchStatus<T>()
    data class Error(val exception: Exception) : SearchStatus<Nothing>()
    object Loading : SearchStatus<Nothing>()
    object Empty : SearchStatus<Nothing>()
    object Idle : SearchStatus<Nothing>()
}