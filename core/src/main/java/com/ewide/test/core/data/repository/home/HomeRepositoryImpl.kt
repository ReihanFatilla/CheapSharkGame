package com.ewide.test.core.data.repository.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import com.ewide.test.core.data.GameRxPagingSource
import com.ewide.test.core.data.local.LocalDataSource
import com.ewide.test.core.data.remote.RemoteDataSource
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.repository.home.HomeRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class HomeRepositoryImpl(
    val remoteDataSource: RemoteDataSource,
    val localDataSource: LocalDataSource,
) : HomeRepository {
    override fun getGames(): LiveData<PagingData<Game>> {
        val liveData = MutableLiveData<PagingData<Game>>()

        CoroutineScope(Dispatchers.IO).launch {
            val sortByFlow = localDataSource.getSortBySetting()
            val sortOrderFlow = localDataSource.getSortOrderSetting()
            combine(sortByFlow, sortOrderFlow) { sortBy, sortOrder ->
                val isDescending = if (sortOrder) 1 else 0
                Pager(
                    config = PagingConfig(
                        pageSize = 15
                    ),
                    pagingSourceFactory = {
                        GameRxPagingSource { pageNumber ->
                            remoteDataSource.getGamesBySort(
                                pageNumber = pageNumber,
                                sortBy = sortBy,
                                descending = isDescending)
                        }
                    }
                ).flowable
            }.collect {
                it.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        liveData.postValue(it)
                    }
            }
        }

        return liveData
    }

    override fun searchGames(query: String): LiveData<PagingData<Game>> {
        val liveData = MutableLiveData<PagingData<Game>>()

        CoroutineScope(Dispatchers.IO).launch {

            val sortByFlow = localDataSource.getSortBySetting()
            val sortOrderFlow = localDataSource.getSortOrderSetting()
            combine(sortByFlow, sortOrderFlow) { sortBy, sortOrder ->
                val isDescending = if (sortOrder) 1 else 0
                Pager(
                    config = PagingConfig(
                        pageSize = 15
                    ),
                    pagingSourceFactory = {
                        GameRxPagingSource { pageNumber ->
                            remoteDataSource.searchGamesBySort(
                                query = query,
                                pageNumber = pageNumber,
                                sortBy = sortBy,
                                descending = isDescending
                            )
                        }
                    }
                ).flowable
            }.collect {
                it
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { pagingData ->
                        liveData.postValue(pagingData)
                    }
            }

        }

        return liveData
    }

}