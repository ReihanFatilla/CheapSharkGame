package com.ewide.test.core.domain.usecase.detail

import com.ewide.test.core.data.local.room.entity.GameEntity
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.repository.detail.DetailRepository
import io.reactivex.rxjava3.core.Flowable

class DetaiInteractor(val detailRepository: DetailRepository): DetailUseCase {
    override fun searchGames(query: String): Flowable<List<Game>> {
        return detailRepository.searchGames(query)
    }

    override fun insertFavorite(game: Game) {
        return detailRepository.insertFavorite(game)
    }

    override fun deleteFavorite(game: Game) {
        return detailRepository.deleteFavorite(game)
    }
}