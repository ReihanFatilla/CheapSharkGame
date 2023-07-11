package com.ewide.test.core.data.remote.retrofit

import com.ewide.test.core.data.remote.response.GameResponse
import com.ewide.test.core.data.remote.response.GameResponseItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Query

interface ApiService {
    fun getGames(
        @Query("pageNumber")
        pageNumber: String,
        @Query("pageSize")
        pageSize: String = "15"
    ): Single<GameResponse>
}