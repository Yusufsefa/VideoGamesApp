package com.yyusufsefa.videogamesapp.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.yyusufsefa.videogamesapp.R
import com.yyusufsefa.videogamesapp.common.BaseFragment
import com.yyusufsefa.videogamesapp.data.viewstate.DetailGameViewState
import com.yyusufsefa.videogamesapp.databinding.FragmentDetailBinding
import com.yyusufsefa.videogamesapp.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    private val viewmodel: DetailViewModel by viewModels()

    private var gameName: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeDetailGame()
        initUI()
    }

    private fun observeDetailGame() {
        viewmodel.gameDetail.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.LOADING -> {
                }
                Status.SUCCESS -> {
                    binding.viewState = DetailGameViewState(it.data!!)
                    it.data.id?.let { _gameId ->
                        checkLiked(_gameId)
                        viewmodel.getGameDb(_gameId).observe(viewLifecycleOwner, { game ->
                            binding.game = game
                        })
                    }
                }
                Status.ERROR -> {
                }
            }
        })
    }

    private fun initUI() {
        arguments.let {
            gameName = DetailFragmentArgs.fromBundle(it!!).gameName!!
        }
        viewmodel.getGameDetail(gameName)
    }

    private fun checkLiked(gameId: Int) {
        binding.imgIslike.setOnClickListener {
            viewmodel.updateGame(true, gameId)
            Log.e("like", gameId.toString())
        }
        binding.imgIsliked.setOnClickListener {
            viewmodel.updateGame(false, gameId)
            Log.e("liked", gameId.toString())
        }
    }

}