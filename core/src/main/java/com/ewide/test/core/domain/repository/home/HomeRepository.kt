package com.ewide.test.core.domain.repository.home

import androidx.paging.PagingData
import com.ewide.test.core.domain.model.game.Game
import io.reactivex.rxjava3.core.Flowable

interface HomeRepository {
    fun getGames(): Flowable<PagingData<Game>>
    fun searchGames(query: String): Flowable<PagingData<Game>>
}