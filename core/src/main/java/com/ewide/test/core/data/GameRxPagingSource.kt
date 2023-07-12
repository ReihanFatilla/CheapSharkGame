package com.ewide.test.core.data

import android.util.Log
import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.ewide.test.core.data.local.room.database.GameDatabase
import com.ewide.test.core.data.remote.RemoteDataSource
import com.ewide.test.core.data.remote.response.GameResponse
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.mapper.GameMapper.mapToGame
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GameRxPagingSource(val gameResponse: (Int) -> Single<List<GameResponse>>) : RxPagingSource<Int, Game>() {
    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Game>> {
        val position = params.key ?: 1

        return gameResponse(position)
            .subscribeOn(Schedulers.io())
            .map { response ->
                val games = response.mapToGame()
                val nextKey = if (games.isEmpty()) null else position + 1
                val prevKey = if (position == 1) null else position - 1
                toLoadResult(games, prevKey, nextKey)
            }
            .onErrorReturn { LoadResult.Error(it) }
    }

    private fun toLoadResult(games: List<Game>, prevKey: Int?, nextKey: Int?): LoadResult<Int, Game> {
        return LoadResult.Page(games, prevKey, nextKey)
    }
}