package com.ewide.test.reihan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.reihan.databinding.ItemGameBinding
import com.ewide.test.reihan.databinding.ItemHorizontalGameBinding

class GameAdapter(val itemClicked: (game: Game) -> Unit) :
    RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    private val listGame = ArrayList<Game>()

    fun setGames(list: List<Game>) {
        listGame.clear()
        listGame.addAll(list)
    }

    class GameViewHolder(val binding: ItemGameBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.binding.apply {
            with(listGame[position]) {
                tvTitle.text = title
                tvNormalPrice.text = "$$normalPrice"
                tvSalePrice.text = "$$salePrice"
                tvRatingPercent.text = "$ratingPercent%"
                Glide.with(root.context)
                    .load(thumbUrl)
                    .into(imgGame)
                root.setOnClickListener {
                    itemClicked(this)
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GameViewHolder(
        ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = listGame.size
}