package com.ewide.test.reihan.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.reihan.R
import com.ewide.test.reihan.databinding.FragmentHomeBinding
import com.ewide.test.reihan.presentation.home.HomeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.android.viewmodel.ext.android.viewModel

class DetailDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding as FragmentHomeBinding

    private var _game: Game? = null
    private val game get() = _game as Game

    private val viewModel: DetailViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_dialog, container, false)
    }
}