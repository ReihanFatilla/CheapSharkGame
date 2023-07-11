package com.ewide.test.core.di

import com.ewide.test.core.data.repository.HomeRepositoryImpl
import com.ewide.test.core.domain.repository.home.HomeRepository
import com.ewide.test.core.domain.usecase.home.HomeInteractor
import com.ewide.test.core.domain.usecase.home.HomeUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get()) }
}