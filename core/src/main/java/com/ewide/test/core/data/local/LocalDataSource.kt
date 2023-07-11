package com.ewide.test.core.data.local

import com.ewide.test.core.data.local.datastore.SortDataStore
import com.ewide.test.core.data.local.room.dao.GameDao
import com.ewide.test.core.data.local.room.entity.GameEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    val gameDao: GameDao,
    val sortDataStore: SortDataStore
) {

    fun getFavoriteList(): Flow<List<GameEntity>>{
        return gameDao.getFavoriteList()
    }

    fun getGameById(id: String): Flow<GameEntity?>{
        return gameDao.getGameById(id)
    }

    suspend fun insertFavorite(game: GameEntity){
        gameDao.insertFavorite(game)
    }

    suspend fun deleteFavorite(game: GameEntity){
        gameDao.deleteFavorite(game)
    }

    fun getSortSetting(): Flow<Boolean>{
        return sortDataStore.getSortSetting()
    }

    suspend fun saveThdemeSetting(isDescending: Boolean){
        sortDataStore.saveSortSetting(isDescending)
    }

}