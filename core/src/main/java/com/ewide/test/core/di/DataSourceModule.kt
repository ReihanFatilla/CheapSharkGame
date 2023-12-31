package com.ewide.test.core.di

import com.ewide.test.core.data.local.LocalDataSource
import com.ewide.test.core.data.remote.RemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    factory { RemoteDataSource(get()) }
    factory { LocalDataSource(get(), get()) }
}