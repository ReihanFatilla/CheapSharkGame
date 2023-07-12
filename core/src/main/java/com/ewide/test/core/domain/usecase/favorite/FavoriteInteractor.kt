package com.ewide.test.core.domain.usecase.favorite

import androidx.lifecycle.LiveData
import com.ewide.test.core.data.local.room.entity.GameEntity
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.repository.favorite.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class FavoriteInteractor(val favoriteRepository: FavoriteRepository): FavoriteUseCase {
    override fun getFavoriteList(): Flow<List<Game>> {
        return favoriteRepository.getFavoriteList()
    }

    override fun isFavorite(id: String): LiveData<Boolean> {
        return favoriteRepository.isFavorite(id)
    }
}