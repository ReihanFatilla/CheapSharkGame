package com.ewide.test.reihan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.reihan.databinding.ItemGameBinding

class GamePagingAdapter: PagingDataAdapter<Game, GamePagingAdapter.GameViewHolder>(DIFF_CALLBACK) {

    class GameViewHolder(val binding: ItemGameBinding): RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.binding.apply {
            with(getItem(position)){
                if (this == null) return
                tvTitle.text = title
                tvNormalPrice.text = "$$normalPrice"
                tvSalePrice.text = "$$salePrice"
                tvRatingPercent.text = "$ratingPercent%"
                Glide.with(root.context)
                    .load(thumbUrl)
                    .into(imgGame)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GameViewHolder(
        ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Game>() {
            override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}