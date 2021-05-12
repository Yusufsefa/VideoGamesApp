package com.yyusufsefa.videogamesapp.ui.home

import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.yyusufsefa.videogamesapp.R
import com.yyusufsefa.videogamesapp.common.BaseFragment
import com.yyusufsefa.videogamesapp.data.model.Game
import com.yyusufsefa.videogamesapp.databinding.FragmentHomeBinding
import com.yyusufsefa.videogamesapp.ui.adapter.GameAdapter
import com.yyusufsefa.videogamesapp.ui.adapter.ViewPagerAdapter
import com.yyusufsefa.videogamesapp.util.*
import com.yyusufsefa.videogamesapp.util.wrapper.SearchStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

@FlowPreview
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()

    private val gameAdapter by lazy { GameAdapter() }
    private val vpAdapter by lazy { ViewPagerAdapter() }

    private var currentGameList: List<Game> by Delegates.observable(emptyList(),
        { _, oldValue, newValue ->
            if (oldValue != newValue) {
                gameAdapter.submitList(newValue)
            }
        }
    )

    private val gameDataObserver = Observer<Resource<List<Game>>> { gameDataResource ->
        when (gameDataResource.status) {
            Status.LOADING -> {
                binding.prgLoading.show()
            }
            Status.SUCCESS -> {
                currentGameList =
                    gameDataResource.data?.slice(4 until gameDataResource.data.size).orEmpty()
                initViewPager(gameDataResource.data?.take(3).orEmpty())
                binding.prgLoading.hide()
            }
            Status.ERROR -> {
                requireContext().toast(gameDataResource.message.toString())
                binding.prgLoading.hide()
            }
        }
    }

    override fun initUI() {
        binding.rcycHome.adapter = gameAdapter

        gameAdapter.setOnItemClickListener {
            val action = HomeFragmentDirections.actionHomeToDetailFragment(it.slug)
            findNavController().navigate(action)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean = false

            override fun onQueryTextChange(query: String?): Boolean {
                viewModel.searchGame(query)
                return false
            }
        })
    }

    override fun observeData() {
        viewModel.gameData.observe(viewLifecycleOwner, gameDataObserver)

        lifecycleScope.launch {
            viewModel.searchGame.collect { searchResult ->
                binding.run {
                    viewPagerHome.isVisible = searchResult is SearchStatus.Idle
                    intoTabLayout.isVisible = searchResult is SearchStatus.Idle
                    txtNullResult.isVisible =
                        searchResult is SearchStatus.Empty || searchResult is SearchStatus.Error
                    rcycHome.isVisible =
                        searchResult is SearchStatus.Success || searchResult is SearchStatus.Idle
                }
                when (searchResult) {
                    is SearchStatus.Success -> gameAdapter.submitList(searchResult.list)
                    SearchStatus.Empty -> {
                        binding.txtNullResult.text = getString(R.string.error_message)
                    }
                    is SearchStatus.Error -> {
                        binding.txtNullResult.text = searchResult.exception.localizedMessage
                            ?: getString(R.string.error_message)
                    }
                    SearchStatus.Idle -> gameAdapter.submitList(currentGameList)
                    SearchStatus.Loading -> Unit
                }
            }
        }
    }

    private fun initViewPager(games: List<Game>) {
        vpAdapter.setNewList(games)
        binding.viewPagerHome.adapter = vpAdapter
        TabLayoutMediator(
            binding.intoTabLayout,
            binding.viewPagerHome
        ) { tab, position -> }.attach()
        vpAdapter.setOnItemClickListener {
            navigate(HomeFragmentDirections.actionHomeToDetailFragment(it.slug))
        }
    }
}