package com.ewide.test.core.data.remote.retrofit

import com.ewide.test.core.data.remote.response.GameResponse
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("deals")
    fun getGamesBySort(
        @Query("pageNumber")
        pageNumber: Int,
        @Query("sortBy")
        sortBy: String,
        @Query("desc")
        descending: Int,
        @Query("pageSize")
        pageSize: String = "15",
    ): Single<List<GameResponse>>

    @GET("deals")
    fun searchGames(
        @Query("title")
        query: String,
        @Query("pageNumber")
        pageNumber: Int,
        @Query("pageSize")
        pageSize: String = "15",
    ): Single<List<GameResponse>>

    @GET("deals")
    fun searchGames(
        @Query("title")
        query: String,
        @Query("pageSize")
        pageSize: String = "30",
    ): Flowable<List<GameResponse>>

    @GET("deals")
    fun searchGamesBySort(
        @Query("title")
        query: String,
        @Query("sortBy")
        sortBy: String,
        @Query("desc")
        descending: Int,
        @Query("pageNumber")
        pageNumber: Int,
        @Query("pageSize")
        pageSize: String = "15",
    ): Single<List<GameResponse>>
}