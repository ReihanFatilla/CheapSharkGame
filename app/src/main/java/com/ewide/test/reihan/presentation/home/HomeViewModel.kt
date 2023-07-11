package com.ewide.test.reihan.presentation.home

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.usecase.home.HomeUseCase
import io.reactivex.rxjava3.core.Flowable

class HomeViewModel(val homeUseCase: HomeUseCase): ViewModel() {

    fun getGames(): Flowable<PagingData<Game>>{
        return homeUseCase.getGames()
    }

}