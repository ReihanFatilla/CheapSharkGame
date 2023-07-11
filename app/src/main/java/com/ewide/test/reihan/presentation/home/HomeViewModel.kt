package com.ewide.test.reihan.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.rxjava3.cachedIn
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.usecase.home.HomeUseCase
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.ExperimentalCoroutinesApi

class HomeViewModel(val homeUseCase: HomeUseCase): ViewModel() {

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getGames(): Flowable<PagingData<Game>>{
        return homeUseCase.getGames().cachedIn(viewModelScope)
    }

}