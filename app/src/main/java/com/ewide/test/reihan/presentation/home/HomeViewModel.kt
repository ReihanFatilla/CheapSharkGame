package com.ewide.test.reihan.presentation.home

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.rxjava3.cachedIn
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.usecase.home.HomeUseCase
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.ExperimentalCoroutinesApi

class HomeViewModel(val homeUseCase: HomeUseCase): ViewModel() {

    private val _gameResponse: MediatorLiveData<PagingData<Game>> = MediatorLiveData()
    val gameResponse: LiveData<PagingData<Game>> get() = _gameResponse

    fun getGames() {
        val source = LiveDataReactiveStreams.fromPublisher(
            homeUseCase.getGames().cachedIn(viewModelScope)
        )

        _gameResponse.addSource(source){
            _gameResponse.postValue(it)
            _gameResponse.removeSource(source)
        }
    }

    fun searchGames(query: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            homeUseCase.searchGames(query).cachedIn(viewModelScope)
        )

        _gameResponse.addSource(source){
            _gameResponse.postValue(it)
            _gameResponse.removeSource(source)
        }
    }

}