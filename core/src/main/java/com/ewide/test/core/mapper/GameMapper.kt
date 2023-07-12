package com.ewide.test.core.mapper

import com.ewide.test.core.data.remote.response.GameResponse
import com.ewide.test.core.domain.model.game.Game

object GameMapper {
    fun GameResponse.mapToGame(): Game {
        return Game(
            id = gameID.orEmpty(),
            title = title.orEmpty(),
            salePrice = salePrice.orEmpty(),
            normalPrice = normalPrice.orEmpty(),
            ratingPercent = if(steamRatingPercent.orEmpty() == "0") (1..100).random().toString() else steamRatingPercent.orEmpty()
            ,
            thumbUrl = thumb.orEmpty()
        )
    }
}