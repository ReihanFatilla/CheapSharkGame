package com.ewide.test.core.domain.repository.setting

import kotlinx.coroutines.flow.Flow

interface SettingRepository {
    fun getSortOrderSetting(): Flow<Boolean>
    fun getSortBySetting(): Flow<String>
    suspend fun saveSortOrderSetting(isDescending: Boolean)
    suspend fun saveSortBySetting(sortBy: String)
}