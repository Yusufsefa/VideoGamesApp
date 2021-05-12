package com.yyusufsefa.videogamesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yyusufsefa.videogamesapp.data.model.Game
import com.yyusufsefa.videogamesapp.data.viewstate.GameItemViewState
import com.yyusufsefa.videogamesapp.databinding.ItemGameBinding

class GameAdapter : ListAdapter<Game, GameAdapter.GameViewHolder>(diffCallBack) {

    private var onItemClickListener: ((Game) -> Unit)? = null

    fun setOnItemClickListener(onItemClickListener: ((Game) -> Unit)) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder =
        GameViewHolder(
            ItemGameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            this.itemView.setOnClickListener { onItemClickListener?.invoke(getItem(adapterPosition)) }
        }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) =
        holder.bind(getItem(position))

    class GameViewHolder(private val gameBinding: ItemGameBinding) :
        RecyclerView.ViewHolder(gameBinding.root) {

        fun bind(game: Game) {
            gameBinding.run {
                this.itemViewState = GameItemViewState(game)
            }
        }
    }

    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<Game>() {
            override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean =
                oldItem == newItem
        }
    }
}
