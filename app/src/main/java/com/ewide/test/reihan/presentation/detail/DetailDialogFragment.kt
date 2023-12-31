package com.ewide.test.reihan.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.reihan.adapter.GameHorizontalAdapter
import com.ewide.test.reihan.databinding.FragmentDetailDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.android.viewmodel.ext.android.viewModel

class DetailDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentDetailDialogBinding? = null
    private val binding get() = _binding as FragmentDetailDialogBinding

    private var _game: Game? = null
    private val game get() = _game as Game

    private val viewModel: DetailViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDetailDialogBinding.inflate(layoutInflater)
        _game = arguments?.getParcelable(GAME_BUNDLE)

        setUpView()
        setUpSimilarGame()
        setUpFavorite()

        return binding.root
    }

    private fun setUpFavorite() {
        viewModel.isFavorite(game.id).observe(viewLifecycleOwner) { isFavorite ->
            if (isFavorite) favoriteButtonMode()
            binding.btnFavorite.apply {
                addOnCheckedChangeListener { button, isChecked ->
                    if (isChecked) {
                        text = "Remove from favorite"
                        viewModel.insertFavorite(game)
                    } else {
                        text = "Add to favorite"
                        viewModel.deleteFavorite(game)
                    }
                }
            }
        }
    }

    private fun setUpSimilarGame() {
        binding.rvSimilarGames.apply {
            addVeiledItems(5)
            val mAdapter = GameHorizontalAdapter {
                DetailDialogFragment().also { fragment ->
                    Bundle().also { bundle ->
                        bundle.putParcelable(GAME_BUNDLE, it)
                        fragment.arguments = bundle
                        fragment.show(requireActivity().supportFragmentManager, null)
                    }
                }
            }
            viewModel.searchGames(game.title.split(" ")[0])
            viewModel.gameResponse.observe(viewLifecycleOwner) {
                if(it.isNullOrEmpty()) veil() else unVeil()
                mAdapter.setGames(it)
                setAdapter(mAdapter, LinearLayoutManager(context, RecyclerView.HORIZONTAL, false))
            }
        }
    }

    private fun setUpView() {
        binding.apply {
            with(game) {
                tvTitle.text = title
                tvNormalPrice.text = "$$normalPrice"
                tvSalePrice.text = "$$salePrice"
                tvRatingPercent.text = "$ratingPercent%"
                Glide.with(root.context)
                    .load(thumbUrl)
                    .into(imgGame)
            }
            btnClose.setOnClickListener {
                dismiss()
            }
        }
    }

    fun favoriteButtonMode() {
        binding.btnFavorite.apply {
            isChecked = true
            text = "Remove from favorite"
        }
    }

    companion object {
        const val GAME_BUNDLE = "game_bundle"
    }
}