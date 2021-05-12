package com.yyusufsefa.videogamesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yyusufsefa.videogamesapp.data.model.Game
import com.yyusufsefa.videogamesapp.data.viewstate.VpItemViewPagerState
import com.yyusufsefa.videogamesapp.databinding.ItemPageBinding

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    private var games: List<Game> = emptyList()

    private var onItemClickListener: ((Game) -> Unit)? = null

    fun setOnItemClickListener(onItemClickListener: ((Game) -> Unit)) {
        this.onItemClickListener = onItemClickListener
    }

    fun setNewList(games: List<Game>) {
        this.games = games
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PagerViewHolder = PagerViewHolder(
        ItemPageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    ).apply {
        this.itemView.setOnClickListener { onItemClickListener?.invoke(games[adapterPosition]) }
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) =
        holder.bind(games[position])

    override fun getItemCount(): Int = games.size

    class PagerViewHolder(private var binding: ItemPageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(game: Game) {
            binding.itemViewState = VpItemViewPagerState(game)
        }
    }
}