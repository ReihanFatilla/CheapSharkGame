package com.ewide.test.core.domain.usecase.home

import androidx.paging.PagingData
import com.ewide.test.core.domain.model.SortType
import com.ewide.test.core.domain.model.game.Game
import io.reactivex.rxjava3.core.Flowable

interface HomeUseCase {
    fun getGames(): Flowable<PagingData<Game>>
    fun getGamesBySort(sortBy: SortType): Flowable<PagingData<Game>>
    fun searchGames(query: String): Flowable<PagingData<Game>>
    fun searchGamesBySort(query: String, sortBy: SortType): Flowable<PagingData<Game>>
}