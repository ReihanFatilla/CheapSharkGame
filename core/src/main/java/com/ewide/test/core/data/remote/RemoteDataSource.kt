package com.ewide.test.core.data.remote

import com.ewide.test.core.data.remote.retrofit.ApiService

class RemoteDataSource(val apiService: ApiService) {
    fun getGames(pageNumber: Int) = apiService.getGames(pageNumber)
    fun searchGames(query: String, pageNumber: Int) = apiService.searchGames(query, pageNumber)
}