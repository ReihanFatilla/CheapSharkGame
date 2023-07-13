package com.ewide.test.core.domain.usecase.setting

import kotlinx.coroutines.flow.Flow

interface SettingUseCase {
    fun getSortOrderSetting(): Flow<Boolean>
    fun getSortBySetting(): Flow<String>
    fun saveSortOrderSetting(isDescending: Boolean)
    fun saveSortBySetting(sortBy: String)
}