package com.ewide.test.reihan.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.reihan.R
import com.ewide.test.reihan.databinding.FragmentDetailDialogBinding
import com.ewide.test.reihan.databinding.FragmentHomeBinding
import com.ewide.test.reihan.presentation.home.HomeViewModel
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
        _game = arguments?.getParcelable<Game>(GAME_BUNDLE)
        return binding.root
    }

    companion object{
        const val GAME_BUNDLE = "game_bundle"
    }
}