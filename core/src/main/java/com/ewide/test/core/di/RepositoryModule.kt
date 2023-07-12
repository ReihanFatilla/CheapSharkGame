package com.ewide.test.core.di

import com.ewide.test.core.data.repository.detail.DetailRepositoryImpl
import com.ewide.test.core.data.repository.home.HomeRepositoryImpl
import com.ewide.test.core.domain.repository.detail.DetailRepository
import com.ewide.test.core.domain.repository.home.HomeRepository
import com.ewide.test.core.domain.usecase.detail.DetailUseCase
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get()) }
    single<DetailRepository> { DetailRepositoryImpl(get()) }
}