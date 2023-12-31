package com.ewide.test.reihan.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.reihan.R
import com.ewide.test.reihan.adapter.GamePagingAdapter
import com.ewide.test.reihan.adapter.PagingLoadingAdapter
import com.ewide.test.reihan.databinding.FragmentHomeBinding
import com.ewide.test.reihan.presentation.SortSettings.SettingDialogFragment
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
                SettingDialogFragment().show(requireActivity().supportFragmentManager, null)
            }
        }
    }

    private fun setUpSearchView() {
        binding.svDisney.apply {

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    handler.removeCallbacksAndMessages(null)
                    handler.postDelayed({

                        viewModel.searchGames(newText.orEmpty())
                    }, 300)

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

            viewModel.getGames()
            viewModel.gameResponse.observe(viewLifecycleOwner) {
                mAdapter.submitData(lifecycle, it)
            }
            adapter = mAdapter.withLoadStateFooter(
                footer = PagingLoadingAdapter()
            )

            binding.apply {
                mAdapter.addLoadStateListener { loadState ->
                    val isEmpty =
                        loadState.refresh is LoadState.NotLoading && (adapter as ConcatAdapter).itemCount == 0
                    if (isEmpty) {
                        tvStateMessage.text = "Sorry, Game is not found"
                        imgMessageIcon.setImageResource(R.drawable.ic_close)
                        llStateMessage.visibility = View.VISIBLE
                    } else if ((adapter as ConcatAdapter).itemCount == 0) {
                        llStateMessage.visibility = View.VISIBLE
                    } else {
                        llStateMessage.visibility = View.GONE
                    }
                }
            }

            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setUpStateMessage(pagingData: PagingData<Game>?) {
        binding.apply {
            if (pagingData != null) {
                Log.i("oketest", "setUpStateMessage: jalan 1")

            } else Log.i("oketest", "setUpStateMessage: jalan 2")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}