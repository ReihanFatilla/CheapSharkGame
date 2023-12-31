package com.ewide.test.core.domain.usecase.favorite

import androidx.lifecycle.LiveData
import com.ewide.test.core.data.local.room.entity.GameEntity
import com.ewide.test.core.domain.model.game.Game
import kotlinx.coroutines.flow.Flow

interface FavoriteUseCase {
    fun getFavoriteList(): Flow<List<Game>>
}