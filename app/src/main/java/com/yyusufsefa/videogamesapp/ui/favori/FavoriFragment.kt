package com.yyusufsefa.videogamesapp.ui.favori

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yyusufsefa.videogamesapp.R
import com.yyusufsefa.videogamesapp.common.BaseFragment
import com.yyusufsefa.videogamesapp.databinding.FragmentFavoriBinding
import com.yyusufsefa.videogamesapp.ui.adapter.GameAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriFragment : BaseFragment<FragmentFavoriBinding>(R.layout.fragment_favori) {

    private var gameAdapter = GameAdapter()

    private val viewModel: FavoriViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observerData()
    }

    private fun initUI() {
        binding.rcycFavorite.adapter = gameAdapter
        gameAdapter.setOnItemClickListener {
            val action = FavoriFragmentDirections.actionLikeToDetailFragment(it.slug)
            findNavController().navigate(action)
        }
    }

    private fun observerData() {
        viewModel.allLikedGame.observe(viewLifecycleOwner, {
            gameAdapter.submitList(it)
        })
    }
}