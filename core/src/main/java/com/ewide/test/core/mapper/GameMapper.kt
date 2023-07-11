package com.ewide.test.core.mapper

import com.ewide.test.core.data.remote.response.GameResponse
import com.ewide.test.core.domain.model.game.Game

object GameMapper {
    fun GameResponse.mapToGame(): List<Game> {
        return gameResponse?.map { game ->
            Game(
                title = game?.title.orEmpty(),
                salePrice = game?.salePrice.orEmpty(),
                normalPrice = game?.normalPrice.orEmpty(),
                thumbUrl = game?.thumb.orEmpty()
            )
        } ?: listOf()
    }
}