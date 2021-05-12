package com.yyusufsefa.videogamesapp.util

import android.content.Context
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.yyusufsefa.videogamesapp.data.model.Game
import com.yyusufsefa.videogamesapp.ui.adapter.GameAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Game>) {
    val adapter = recyclerView.adapter as GameAdapter
    adapter.submitList(data.slice(4 until data.size))
}

fun Fragment.navigate(navigation: NavDirections) {
    findNavController().navigate(navigation)
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}