package com.reift.core.di

import com.ewide.test.core.di.dataSourceModule
import com.ewide.test.core.di.networkModule
import com.ewide.test.core.di.repositoryModule
import com.ewide.test.reihan.di.useCaseModule
import com.ewide.test.reihan.di.viewModelModule

val listModules = listOf(
    networkModule,
    repositoryModule,
    dataSourceModule,
    useCaseModule,
    viewModelModule
)