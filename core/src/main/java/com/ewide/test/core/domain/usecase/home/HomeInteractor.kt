package com.ewide.test.core.domain.usecase.home

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.repository.home.HomeRepository
import io.reactivex.rxjava3.core.Flowable

class HomeInteractor(val homeRepository: HomeRepository) : HomeUseCase {
    override fun getGames(): LiveData<PagingData<Game>> {
        return homeRepository.getGames()
    }

    override fun searchGames(query: String): LiveData<PagingData<Game>> {
        return homeRepository.searchGames(query)
    }
}