package com.ewide.test.core.data.remote

import com.ewide.test.core.data.remote.response.GameResponse
import com.ewide.test.core.data.remote.retrofit.ApiService
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

class RemoteDataSource(val apiService: ApiService) {

    fun getGamesBySort(
        pageNumber: Int,
        sortBy: String,
        descending: Int,
    ): Single<List<GameResponse>> {
        return apiService.getGamesBySort(
            pageNumber = pageNumber,
            sortBy = sortBy,
            descending = descending)
    }

    fun searchGames(query: String, pageNumber: Int): Single<List<GameResponse>> {
        return apiService.searchGames(
            query = query,
            pageNumber = pageNumber
        )
    }

    fun searchGames(query: String): Flowable<List<GameResponse>> {
        return apiService.searchGames(query = query)
    }

    fun searchGamesBySort(
        query: String,
        pageNumber: Int,
        sortBy: String,
        descending: Int,
    ): Single<List<GameResponse>> {
        return apiService.searchGamesBySort(
            query = query,
            sortBy = sortBy,
            pageNumber = pageNumber,
            descending = descending
        )
    }
}