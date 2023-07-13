package com.ewide.test.core.domain.repository.setting

import kotlinx.coroutines.flow.Flow

interface SettingRepository {
    fun getSortOrderSetting(): Flow<Boolean>
    fun getSortBySetting(): Flow<String>
    fun saveSortOrderSetting(isDescending: Boolean)
    fun saveSortBySetting(sortBy: String)
}