package com.ewide.test.core.data.remote

import com.ewide.test.core.data.remote.retrofit.ApiService

class RemoteDataSource(val apiService: ApiService) {
    fun getGames(pageNumber: Int) = apiService.getGames(pageNumber)
    fun getGamesBySort(pageNumber: Int, sortBy: String) = apiService.getGamesBySort(pageNumber, sortBy)
    fun searchGames(query: String, pageNumber: Int) = apiService.searchGames(query, pageNumber)
    fun searchGames(query: String) = apiService.searchGames(query)
    fun searchGamesBySort(query: String, sortBy: String, pageNumber: Int) = apiService.searchGamesBySort(query, sortBy, pageNumber)
}