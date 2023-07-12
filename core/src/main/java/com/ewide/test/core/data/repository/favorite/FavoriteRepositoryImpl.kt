package com.ewide.test.core.data.repository.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ewide.test.core.data.local.LocalDataSource
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.repository.favorite.FavoriteRepository
import com.ewide.test.core.mapper.GameMapper.mapToDomain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FavoriteRepositoryImpl(val localDataSource: LocalDataSource) : FavoriteRepository {
    override fun getFavoriteList(): Flow<List<Game>> {
        return localDataSource.getFavoriteList().map { it.mapToDomain() }
    }
}