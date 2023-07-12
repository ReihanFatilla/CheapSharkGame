package com.ewide.test.core.di

import com.ewide.test.core.data.repository.home.HomeRepositoryImpl
import com.ewide.test.core.domain.repository.home.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get()) }
}