package com.ewide.test.core.domain.usecase.home

import androidx.paging.PagingData
import com.ewide.test.core.domain.model.SortType
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.repository.home.HomeRepository
import io.reactivex.rxjava3.core.Flowable

class HomeInteractor(val homeRepository: HomeRepository): HomeUseCase {
    override fun getGames(): Flowable<PagingData<Game>> {
        return homeRepository.getGames()
    }

    override fun getGamesBySort(sortBy: SortType): Flowable<PagingData<Game>> {
        return homeRepository.getGamesBySort(sortBy)
    }

    override fun searchGames(query: String): Flowable<PagingData<Game>> {
        return homeRepository.searchGames(query)
    }

    override fun searchGamesBySort(query: String, sortBy: SortType): Flowable<PagingData<Game>> {
        return homeRepository.searchGamesBySort(query, sortBy)
    }
}