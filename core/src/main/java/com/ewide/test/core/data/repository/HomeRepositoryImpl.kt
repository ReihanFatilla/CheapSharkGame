package com.ewide.test.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import com.ewide.test.core.data.GamePagingSource
import com.ewide.test.core.data.remote.RemoteDataSource
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.repository.home.HomeRepository
import io.reactivex.rxjava3.core.Flowable

class HomeRepositoryImpl(val remoteDataSource: RemoteDataSource): HomeRepository {
    override fun getGames(): Flowable<PagingData<Game>> {
        return Pager(
            config = PagingConfig(
                pageSize = 15,
                enablePlaceholders = true,
                maxSize = 30,
                initialLoadSize = 40
            ),
            pagingSourceFactory = { GamePagingSource(remoteDataSource.apiService) }
        ).flowable
    }
}