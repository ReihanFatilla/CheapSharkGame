package com.ewide.test.reihan.presentation.home

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.rxjava3.cachedIn
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.usecase.home.HomeUseCase
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.ExperimentalCoroutinesApi

class HomeViewModel(val homeUseCase: HomeUseCase): ViewModel() {

    private val _gameResponse: MediatorLiveData<PagingData<Game>> = MediatorLiveData()
    val gameResponse: LiveData<PagingData<Game>> get() = _gameResponse

    fun getGames() {
        _gameResponse.addSource(homeUseCase.getGames().cachedIn(viewModelScope)){ pagingData ->
            _gameResponse.postValue(pagingData)
        }
    }

    fun searchGames(query: String) {
        _gameResponse.addSource(homeUseCase.searchGames(query).cachedIn(viewModelScope)){ pagingData ->
            _gameResponse.postValue(pagingData)
        }
    }

}