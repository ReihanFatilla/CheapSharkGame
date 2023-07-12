package com.ewide.test.reihan.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewide.test.reihan.adapter.GamePagingAdapter
import com.ewide.test.reihan.databinding.FragmentHomeBinding
import com.ewide.test.reihan.presentation.SortSettings.SortSettingsDialogFragment
import com.ewide.test.reihan.presentation.detail.DetailDialogFragment
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding as FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        setUpView()
        setUpSearchView()
        setUpRecyclerView()

        return binding.root
    }

    private fun setUpView() {
        binding.apply {
            btnSortSettings.setOnClickListener {
                SortSettingsDialogFragment().show(requireActivity().supportFragmentManager, null)
            }
        }
    }

    private fun setUpSearchView() {
        binding.svDisney.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    viewModel.searchGames(query.orEmpty())
                    return true
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    viewModel.searchGames(query.orEmpty())
                    return true
                }

            })
        }
    }

    private fun setUpRecyclerView() {
        binding.rvGames.apply {
            val mAdapter = GamePagingAdapter { game ->
                DetailDialogFragment().also { fragment ->
                    Bundle().also { bundle ->
                        bundle.putParcelable(DetailDialogFragment.GAME_BUNDLE, game)
                        fragment.arguments = bundle
                        fragment.show(requireActivity().supportFragmentManager, null)
                    }
                }
            }
            viewModel.getGames().observe(viewLifecycleOwner) {
                mAdapter.submitData(lifecycle, it)
            }
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}