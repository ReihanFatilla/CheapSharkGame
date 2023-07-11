package com.ewide.test.core.di

import androidx.room.Room
import com.ewide.test.core.data.local.room.database.GameDatabase
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<GameDatabase>().gameDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("gamedatabase".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            GameDatabase::class.java, "game.database"
        )
            .fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}