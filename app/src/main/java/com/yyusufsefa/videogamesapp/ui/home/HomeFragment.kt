package com.yyusufsefa.videogamesapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.yyusufsefa.videogamesapp.R
import com.yyusufsefa.videogamesapp.common.BaseFragment
import com.yyusufsefa.videogamesapp.data.model.Game
import com.yyusufsefa.videogamesapp.databinding.FragmentHomeBinding
import com.yyusufsefa.videogamesapp.ui.adapter.GameAdapter
import com.yyusufsefa.videogamesapp.ui.adapter.ViewPagerAdapter
import com.yyusufsefa.videogamesapp.util.Status
import com.yyusufsefa.videogamesapp.util.hide
import com.yyusufsefa.videogamesapp.util.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewmodel: HomeViewModel by viewModels()

    private var gameAdapter = GameAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        observeGame()

    }

    private fun initUI() {
        binding.rcycHome.adapter = gameAdapter
        gameAdapter.setOnItemClickListener {
            val action = HomeFragmentDirections.actionHomeToDetailFragment(it.slug)
            findNavController().navigate(action)
        }
    }

    private fun observeGame() {
        viewmodel.gameData.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.LOADING -> {
                }
                Status.SUCCESS -> {
                    gameAdapter.submitList(it.data?.slice(4 until it.data.size))
                    gameAdapter.notifyDataSetChanged()
                    initViewPager(it.data!!.take(3))
                }
                Status.ERROR -> {
                }
            }
        })
    }

    private fun initViewPager(games: List<Game>) {
        val vpAdapter = ViewPagerAdapter(games)
        binding.viewPagerHome.adapter = vpAdapter
        binding.indicator.setViewPager(binding.viewPagerHome)

        vpAdapter.setOnItemClickListener {
            val action = HomeFragmentDirections.actionHomeToDetailFragment(it.slug)
            findNavController().navigate(action)
        }

        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean = true

            override fun onQueryTextChange(query: String?): Boolean {
                if (query != null && query.length >= 3) {
                    binding.viewPagerHome.hide()
                    binding.indicator.hide()
                    binding.txtNullResult.hide()
                    searchDatabase(query)
                } else {
                    binding.viewPagerHome.show()
                    binding.indicator.show()
                    binding.rcycHome.show()
                    binding.txtNullResult.hide()
                    observeGame()
                }
                return true
            }
        })
    }

    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"
        viewmodel.searchDatabase(searchQuery).observe(viewLifecycleOwner, Observer {
            it.let {
                gameAdapter.submitList(it)
            }
            if (it.isEmpty()) {
                binding.viewPagerHome.hide()
                binding.indicator.hide()
                binding.rcycHome.hide()
                binding.txtNullResult.show()
            }
        })
    }


}