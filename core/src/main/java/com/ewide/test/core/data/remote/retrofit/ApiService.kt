package com.ewide.test.core.data.remote.retrofit

import io.reactivex.rxjava3.core.Single
import retrofit2.http.Query

interface ApiService {
    fun getDisneyCharacters(
        @Query("page")
        page: String
    ): Single<DisneyResultResponse>
}