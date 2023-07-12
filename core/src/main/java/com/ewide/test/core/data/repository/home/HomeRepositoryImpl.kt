package com.ewide.test.core.data.repository.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import androidx.paging.rxjava3.flowable
import com.ewide.test.core.data.GameRxPagingSource
import com.ewide.test.core.data.local.LocalDataSource
import com.ewide.test.core.data.remote.RemoteDataSource
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.repository.home.HomeRepository
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class HomeRepositoryImpl(
    val remoteDataSource: RemoteDataSource,
    val localDataSource: LocalDataSource,
) : HomeRepository {
    override fun getGames(): LiveData<PagingData<Game>> {
        val liveData = MutableLiveData<PagingData<Game>>()

        CoroutineScope(Dispatchers.IO).launch {
            val sortBy = localDataSource.getSortBySetting().first()
            val sortOrder = if (localDataSource.getSortOrderSetting().first()) 1 else 0

            liveData.postValue(
                Pager(
                    config = PagingConfig(
                        pageSize = 15
                    ),
                    pagingSourceFactory = {
                        GameRxPagingSource { pageNumber ->
                            remoteDataSource.getGamesBySort(pageNumber, sortBy, sortOrder)
                        }
                    }
                ).flow.first()
            )
        }

        return liveData
    }

    override fun searchGames(query: String): Flowable<PagingData<Game>> {
        return Pager(
            config = PagingConfig(
                pageSize = 15
            ),
            pagingSourceFactory = { GameRxPagingSource { remoteDataSource.searchGames(query, it) } }
        ).flowable
    }

}