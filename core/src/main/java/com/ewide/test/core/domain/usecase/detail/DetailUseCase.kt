package com.ewide.test.core.domain.usecase.detail

import androidx.paging.PagingData
import com.ewide.test.core.data.local.room.entity.GameEntity
import com.ewide.test.core.domain.model.game.Game
import io.reactivex.rxjava3.core.Flowable

interface DetailUseCase {
    fun searchGames(query: String): Flowable<List<Game>>
    fun insertFavorite(game: Game)
    fun deleteFavorite(game: Game)
}