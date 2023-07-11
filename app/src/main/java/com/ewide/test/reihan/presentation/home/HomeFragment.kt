package com.ewide.test.reihan.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewide.test.reihan.adapter.GamePagingAdapter
import com.ewide.test.reihan.databinding.FragmentHomeBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding as FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModel()

    private val mDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        setUpRecyclerView()

        return binding.root
    }

    private fun setUpRecyclerView() {
        binding.rvGames.apply {
            val mAdapter = GamePagingAdapter()
            mDisposable.add(viewModel.getGames().subscribe{
                mAdapter.submitData(lifecycle, it)
            })
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mDisposable.dispose()
        _binding = null
    }
}