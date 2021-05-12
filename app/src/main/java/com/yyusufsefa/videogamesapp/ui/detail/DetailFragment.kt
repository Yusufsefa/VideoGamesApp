package com.yyusufsefa.videogamesapp.ui.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.yyusufsefa.videogamesapp.R
import com.yyusufsefa.videogamesapp.common.BaseFragment
import com.yyusufsefa.videogamesapp.data.viewstate.DetailGameViewState
import com.yyusufsefa.videogamesapp.databinding.FragmentDetailBinding
import com.yyusufsefa.videogamesapp.util.Status
import com.yyusufsefa.videogamesapp.util.hide
import com.yyusufsefa.videogamesapp.util.show
import com.yyusufsefa.videogamesapp.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    private val viewModel: DetailViewModel by viewModels()
    private val navArgs by navArgs<DetailFragmentArgs>()

    override fun observeData() {
        viewModel.gameDetail.observe(viewLifecycleOwner, { response ->
            when (response.status) {
                Status.LOADING -> {
                    binding.progressBar.show()
                }
                Status.SUCCESS -> {
                    binding.progressBar.hide()
                    val gameDetail = response.data
                    gameDetail?.id?.let { _gameId ->
                        viewModel.getGameDb(_gameId).observe(viewLifecycleOwner, { game ->
                            binding.viewState = DetailGameViewState(gameDetail, game)
                            binding.imgIslike.setOnClickListener {
                                viewModel.updateGame(game.isLiked.not(), _gameId)
                            }
                        })
                    }
                }
                Status.ERROR -> {
                    binding.progressBar.hide()
                    requireContext().toast(response.message.toString())
                }
            }
        })
    }

    override fun initUI() {
        super.initUI()
        viewModel.getGameDetail(navArgs.gameName ?: NONE)
    }

    companion object {
        private const val NONE = "None"
    }
}