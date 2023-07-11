package com.ewide.test.core.domain.usecase.home

import com.ewide.test.core.domain.model.Resource
import com.ewide.test.core.domain.model.disney.Disney
import io.reactivex.rxjava3.core.Flowable

interface HomeUseCase {
    fun getDisneyCharacter(page: String): Flowable<Resource<List<Disney>>>
}