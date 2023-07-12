package com.ewide.test.reihan.presentation.favorite

import androidx.lifecycle.*
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.usecase.favorite.FavoriteUseCase
import kotlinx.coroutines.flow.Flow

class FavoriteViewModel(val favoriteUseCase: FavoriteUseCase): ViewModel() {

    fun getFavoriteList(): LiveData<List<Game>> {
        return favoriteUseCase.getFavoriteList().asLiveData()
    }

    fun isFavorite(id: String): LiveData<Boolean> {
        return favoriteUseCase.isFavorite(id)
    }
}