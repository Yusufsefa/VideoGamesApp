package com.yyusufsefa.videogamesapp.ui.favori

import androidx.fragment.app.viewModels
import com.yyusufsefa.videogamesapp.R
import com.yyusufsefa.videogamesapp.common.BaseFragment
import com.yyusufsefa.videogamesapp.databinding.FragmentFavoriBinding
import com.yyusufsefa.videogamesapp.ui.adapter.GameAdapter
import com.yyusufsefa.videogamesapp.util.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriFragment : BaseFragment<FragmentFavoriBinding>(R.layout.fragment_favori) {

    private var gameAdapter = GameAdapter()

    private val viewModel: FavoriViewModel by viewModels()

    override fun initUI() {
        binding.rcycFavorite.adapter = gameAdapter
        gameAdapter.setOnItemClickListener {
            navigate(FavoriFragmentDirections.actionLikeToDetailFragment(it.slug))
        }
    }

    override fun observeData() {
        viewModel.allLikedGame.observe(viewLifecycleOwner, {
            gameAdapter.submitList(it)
        })
    }
}