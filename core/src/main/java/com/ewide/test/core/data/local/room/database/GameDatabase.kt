package com.ewide.test.core.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ewide.test.core.data.local.room.dao.GameDao
import com.ewide.test.core.data.local.room.entity.GameEntity

@Database(entities = [GameEntity::class], version = 1, exportSchema = false )
abstract class GameDatabase: RoomDatabase() {
    abstract fun gameDao(): GameDao
}