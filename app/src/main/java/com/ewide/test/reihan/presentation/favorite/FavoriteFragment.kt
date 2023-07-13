package com.ewide.test.reihan.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewide.test.reihan.adapter.GameAdapter
import com.ewide.test.reihan.adapter.GameHorizontalAdapter
import com.ewide.test.reihan.databinding.FragmentFavoriteBinding
import com.ewide.test.reihan.presentation.detail.DetailDialogFragment
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding as FragmentFavoriteBinding

    private val viewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFavoriteBinding.inflate(layoutInflater)

        setUpRecyclerView()


        return binding.root
    }

    private fun setUpRecyclerView() {
        binding.rvFavoriteGame.apply {
            val mAdapter = GameAdapter { game ->
                DetailDialogFragment().also { fragment ->
                    Bundle().also { bundle ->
                        bundle.putParcelable(DetailDialogFragment.GAME_BUNDLE, game)
                        fragment.arguments = bundle
                        fragment.show(requireActivity().supportFragmentManager, null)
                    }
                }
            }

            viewModel.getFavoriteList().observe(viewLifecycleOwner) {
                binding.llFavoriteEmpty.visibility = if(it.isNullOrEmpty()) View.VISIBLE else View.GONE
                adapter = mAdapter
                mAdapter.setGames(it)
            }
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}