package com.ewide.test.core.domain.usecase.home

import androidx.paging.PagingData
import com.ewide.test.core.domain.model.game.Game
import io.reactivex.rxjava3.core.Flowable

interface HomeUseCase {
    fun getDisneyCharacters(): Flowable<PagingData<Game>>
}