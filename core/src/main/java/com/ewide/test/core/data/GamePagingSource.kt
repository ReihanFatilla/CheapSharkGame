package com.ewide.test.core.data

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.ewide.test.core.data.remote.retrofit.ApiService
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.mapper.GameMapper.mapToGame
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GamePagingSource(val apiService: ApiService): RxPagingSource<Int, Game>() {

    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Game>> {
        val position = params.key ?: 1
        return apiService.getGames(position)
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(it.mapToGame(), position) }
            .onErrorReturn { LoadResult.Error(it) }
    }

    private fun toLoadResult(data: List<Game>, position: Int): LoadResult<Int, Game> {
        val prevKey = if (position > 1) position - 1 else null
        val nextKey = if (data.isNotEmpty()) position + 1 else null
        return LoadResult.Page(data, prevKey, nextKey)
    }

}