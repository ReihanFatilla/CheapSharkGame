package com.ewide.test.core.data

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.ewide.test.core.domain.model.game.Game
import io.reactivex.rxjava3.core.Single

class GamePagingSource(): RxPagingSource<Int, Game>() {
    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        TODO("Not yet implemented")
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Game>> {
        TODO("Not yet implemented")
    }
}