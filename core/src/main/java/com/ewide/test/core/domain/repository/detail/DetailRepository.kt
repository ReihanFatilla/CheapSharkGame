package com.ewide.test.core.domain.repository.detail

import com.ewide.test.core.domain.model.game.Game
import io.reactivex.rxjava3.core.Flowable

interface DetailRepository {
    fun searchGames(query: String): Flowable<List<Game>>
}