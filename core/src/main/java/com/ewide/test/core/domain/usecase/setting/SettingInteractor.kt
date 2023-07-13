package com.ewide.test.core.domain.usecase.setting

import com.ewide.test.core.domain.repository.setting.SettingRepository
import kotlinx.coroutines.flow.Flow

class SettingInteractor(val settingRepository: SettingRepository): SettingUseCase {
    override fun getSortOrderSetting(): Flow<Boolean> {
        return settingRepository.getSortOrderSetting()
    }

    override fun getSortBySetting(): Flow<String> {
        return settingRepository.getSortBySetting()
    }

    override fun saveSortOrderSetting(isDescending: Boolean) {
        settingRepository.saveSortOrderSetting(isDescending)
    }

    override fun saveSortBySetting(sortBy: String) {
        settingRepository.saveSortBySetting(sortBy)
    }
}