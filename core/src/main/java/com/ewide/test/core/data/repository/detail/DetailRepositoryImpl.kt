package com.ewide.test.core.data.repository.detail

import com.ewide.test.core.data.remote.RemoteDataSource
import com.ewide.test.core.domain.model.game.Game
import com.ewide.test.core.domain.repository.detail.DetailRepository
import com.ewide.test.core.mapper.GameMapper.mapToGame
import io.reactivex.rxjava3.core.Flowable

class DetailRepositoryImpl(val remoteDataSource: RemoteDataSource): DetailRepository {
    override fun searchGames(query: String): Flowable<List<Game>> {
        return remoteDataSource.searchGames(query).map {
            it.mapToGame()
        }
    }
}