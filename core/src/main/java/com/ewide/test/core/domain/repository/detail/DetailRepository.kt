package com.ewide.test.core.domain.repository.detail

import com.ewide.test.core.data.local.room.entity.GameEntity
import com.ewide.test.core.domain.model.game.Game
import io.reactivex.rxjava3.core.Flowable

interface DetailRepository {
    fun searchGames(query: String): Flowable<List<Game>>
    fun insertFavorite(game: Game)
    fun deleteFavorite(game: Game)
}