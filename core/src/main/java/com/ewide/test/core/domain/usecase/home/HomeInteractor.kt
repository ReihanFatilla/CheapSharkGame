package com.ewide.test.core.domain.usecase.home

import androidx.paging.PagingData
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.repository.home.HomeRepository
import io.reactivex.rxjava3.core.Flowable

class HomeInteractor(val homeRepository: HomeRepository): HomeUseCase {
    override fun getGames(): Flowable<PagingData<Game>> {
        return homeRepository.getGames()
    }
}