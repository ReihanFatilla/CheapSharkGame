package com.ewide.test.core.data

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.ewide.test.core.domain.model.disney.Disney
import io.reactivex.rxjava3.core.Single

class DIsneyPagingSource(): RxPagingSource<Int, Disney>() {
    override fun getRefreshKey(state: PagingState<Int, Disney>): Int? {
        TODO("Not yet implemented")
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Disney>> {
        TODO("Not yet implemented")
    }
}