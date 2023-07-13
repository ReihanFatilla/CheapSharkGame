package com.ewide.test.reihan.di

import com.ewide.test.core.domain.usecase.detail.DetaiInteractor
import com.ewide.test.core.domain.usecase.detail.DetailUseCase
import com.ewide.test.core.domain.usecase.favorite.FavoriteInteractor
import com.ewide.test.core.domain.usecase.favorite.FavoriteUseCase
import com.ewide.test.core.domain.usecase.home.HomeInteractor
import com.ewide.test.core.domain.usecase.home.HomeUseCase
import com.ewide.test.core.domain.usecase.setting.SettingInteractor
import com.ewide.test.core.domain.usecase.setting.SettingUseCase
import com.ewide.test.reihan.presentation.SortSettings.SettingViewModel
import com.ewide.test.reihan.presentation.detail.DetailViewModel
import com.ewide.test.reihan.presentation.favorite.FavoriteViewModel
import com.ewide.test.reihan.presentation.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single<HomeUseCase> { HomeInteractor(get()) }
    single<DetailUseCase> { DetaiInteractor(get()) }
    single<FavoriteUseCase> { FavoriteInteractor(get()) }
    single<SettingUseCase> { SettingInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { SettingViewModel(get()) }
}