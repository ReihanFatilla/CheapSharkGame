package com.ewide.test.reihan.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ewide.test.reihan.databinding.PagingLoadingBinding

class PagingLoadingAdapter : LoadStateAdapter<PagingLoadingAdapter.PagingLoadingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState)= PagingLoadingViewHolder(
        PagingLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PagingLoadingViewHolder, loadState: LoadState) {
        holder.binding.apply {
            progressBar.isVisible = loadState is LoadState.Loading
            tvMaxPage.isVisible = loadState is LoadState.Error
        }
    }

    class PagingLoadingViewHolder(val binding: PagingLoadingBinding) : RecyclerView.ViewHolder(binding.root)

}