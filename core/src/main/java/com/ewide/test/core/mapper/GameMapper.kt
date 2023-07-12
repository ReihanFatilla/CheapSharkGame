package com.ewide.test.core.mapper

import com.ewide.test.core.data.local.room.entity.GameEntity
import com.ewide.test.core.data.remote.response.GameResponse
import com.ewide.test.core.domain.model.game.Game

object GameMapper {
    fun List<GameResponse>.mapToGame(): List<Game> {
        return map {
            with(it) {
                Game(
                    id = gameID.orEmpty(),
                    title = title.orEmpty(),
                    salePrice = salePrice.orEmpty(),
                    normalPrice = normalPrice.orEmpty(),
                    ratingPercent = if (steamRatingPercent.orEmpty() == "0") (1..100).random()
                        .toString() else steamRatingPercent.orEmpty(),
                    thumbUrl = thumb.orEmpty()
                )
            }
        }
    }

    fun List<GameEntity>.mapToDomain(): List<Game> {
        return map {
            with(it) {
                Game(
                    id = id,
                    title = title,
                    salePrice = salePrice,
                    normalPrice = normalPrice.orEmpty(),
                    ratingPercent = ratingPercent,
                    thumbUrl = thumbUrl
                )
            }
        }
    }

    fun Game.toGameEntity(): GameEntity {
        return GameEntity(
            id = id,
            title = title,
            salePrice = salePrice,
            normalPrice = normalPrice,
            ratingPercent = ratingPercent,
            thumbUrl = thumbUrl,
        )
    }
}