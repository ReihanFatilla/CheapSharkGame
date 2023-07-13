package com.ewide.test.core.data.repository.setting

import com.ewide.test.core.data.local.LocalDataSource
import com.ewide.test.core.domain.repository.setting.SettingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SettingRepositoryImpl(val localDataSource: LocalDataSource): SettingRepository {
    override fun getSortOrderSetting(): Flow<Boolean> {
        return localDataSource.getSortOrderSetting()
    }

    override fun getSortBySetting(): Flow<String> {
        return localDataSource.getSortBySetting()
    }

    override fun saveSortOrderSetting(isDescending: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.saveSortOrderSetting(isDescending)
        }
    }

    override fun saveSortBySetting(sortBy: String) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.saveSortBySetting(sortBy)
        }
    }
}