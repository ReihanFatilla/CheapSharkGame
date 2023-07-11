package com.ewide.test.core.domain.repository.home

import androidx.paging.PagingData
import com.ewide.test.core.domain.model.game.Game
import io.reactivex.rxjava3.core.Flowable

interface HomeRepository {
    fun getDisneyCharacters(): Flowable<PagingData<Game>>
}