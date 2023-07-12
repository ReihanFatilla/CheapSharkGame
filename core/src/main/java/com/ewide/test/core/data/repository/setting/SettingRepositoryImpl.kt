package com.ewide.test.core.data.repository.setting

import com.ewide.test.core.data.local.LocalDataSource
import com.ewide.test.core.domain.repository.setting.SettingRepository
import kotlinx.coroutines.flow.Flow

class SettingRepositoryImpl(val localDataSource: LocalDataSource): SettingRepository {
    override fun getSortOrderSetting(): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override fun getSortBySetting(): Flow<String> {
        TODO("Not yet implemented")
    }

    override suspend fun saveSortOrderSetting(isDescending: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun saveSortBySetting(sortBy: String) {
        TODO("Not yet implemented")
    }
}