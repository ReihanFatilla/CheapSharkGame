package com.ewide.test.core.data.local.room

import androidx.room.*
import com.ewide.test.core.data.local.room.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM GameEntity")
    fun getFavoriteList(): Flow<List<GameEntity>>

    @Query("SELECT * FROM GameEntity WHERE id LIKE :id")
    fun getGameById(id: String): Flow<GameEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(user: GameEntity)

    @Delete
    suspend fun deleteFavorite(user: GameEntity)

}