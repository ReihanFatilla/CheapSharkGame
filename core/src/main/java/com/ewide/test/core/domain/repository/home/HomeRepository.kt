package com.ewide.test.core.domain.repository.home

import com.ewide.test.core.domain.model.Resource
import com.ewide.test.core.domain.model.disney.Disney
import io.reactivex.rxjava3.core.Flowable

interface HomeRepository {
    fun getDisneyCharacter(page: String): Flowable<Resource<List<Disney>>>
}