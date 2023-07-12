package com.ewide.test.core.data.repository.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ewide.test.core.data.local.LocalDataSource
import com.ewide.test.core.data.local.room.entity.GameEntity
import com.ewide.test.core.data.remote.RemoteDataSource
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.repository.detail.DetailRepository
import com.ewide.test.core.mapper.GameMapper.mapToGame
import com.ewide.test.core.mapper.GameMapper.toGameEntity
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class DetailRepositoryImpl(val remoteDataSource: RemoteDataSource, val localDataSource: LocalDataSource): DetailRepository {
    override fun searchGames(query: String): Flowable<List<Game>> {
        return remoteDataSource.searchGames(query).map {
            it.mapToGame()
        }
    }

    override fun insertFavorite(game: Game) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.insertFavorite(game.toGameEntity())
        }
    }

    override fun deleteFavorite(game: Game) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.deleteFavorite(game.toGameEntity())
        }
    }

    override fun isFavorite(id: String): LiveData<Boolean> {
        return MutableLiveData<Boolean>().also { liveData ->
            CoroutineScope(Dispatchers.IO).launch {
                liveData.postValue(localDataSource.getGameById(id).first() != null)
            }
        }
    }
}