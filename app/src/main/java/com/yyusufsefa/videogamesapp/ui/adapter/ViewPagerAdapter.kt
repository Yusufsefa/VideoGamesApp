package com.yyusufsefa.videogamesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yyusufsefa.videogamesapp.data.model.Game
import com.yyusufsefa.videogamesapp.data.viewstate.VpItemViewPagerState
import com.yyusufsefa.videogamesapp.databinding.ItemPageBinding

class ViewPagerAdapter(private var games: List<Game>) :
    RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    private var onItemClickListener: ((Game) -> Unit)? = null

    fun setOnItemClickListener(onItemClickListener: ((Game) -> Unit)) {
        this.onItemClickListener = onItemClickListener
    }

    class Pager2ViewHolder(private var binding: ItemPageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(game: Game, onItemClickListener: ((Game) -> Unit)?) {
            binding.apply {
                this.itemViewState = VpItemViewPagerState(game)
                root.setOnClickListener { onItemClickListener?.invoke(game) }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Pager2ViewHolder = Pager2ViewHolder(
        ItemPageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) =
        holder.bind(games[position], onItemClickListener)

    override fun getItemCount(): Int = games.size
}