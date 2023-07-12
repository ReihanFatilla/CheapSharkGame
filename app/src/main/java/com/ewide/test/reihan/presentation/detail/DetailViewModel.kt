package com.ewide.test.reihan.presentation.detail

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.rxjava3.cachedIn
import com.ewide.test.core.data.local.room.entity.GameEntity
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.usecase.detail.DetailUseCase

class DetailViewModel(val detailUseCase: DetailUseCase): ViewModel() {

    private val _gameResponse: MediatorLiveData<List<Game>> = MediatorLiveData()
    val gameResponse: LiveData<List<Game>> get() = _gameResponse

    fun searchGames(query: String){
        val source = LiveDataReactiveStreams.fromPublisher(
            detailUseCase.searchGames(query)
        )

        _gameResponse.addSource(source){
            _gameResponse.postValue(it)
            _gameResponse.removeSource(source)
        }
    }

    fun insertFavorite(game: Game){
        detailUseCase.insertFavorite(game)
    }

    fun deleteFavorite(game: Game){
        detailUseCase.deleteFavorite(game)
    }

    fun isFavorite(id: String): LiveData<Boolean> {
        return detailUseCase.isFavorite(id)
    }

}