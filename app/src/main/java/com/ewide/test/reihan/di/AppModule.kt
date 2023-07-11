package com.ewide.test.reihan.di

import com.ewide.test.core.domain.usecase.home.HomeInteractor
import com.ewide.test.core.domain.usecase.home.HomeUseCase
import com.ewide.test.reihan.presentation.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single<HomeUseCase> { HomeInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}