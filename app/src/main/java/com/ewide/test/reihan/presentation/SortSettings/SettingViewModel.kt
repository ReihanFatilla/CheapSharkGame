package com.ewide.test.reihan.presentation.SortSettings

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ewide.test.core.domain.usecase.setting.SettingUseCase

class SettingViewModel(val settingUseCase: SettingUseCase): ViewModel() {
    fun getSortOrderSetting(): LiveData<Boolean> {
        return settingUseCase.getSortOrderSetting().asLiveData()
    }
    fun getSortBySetting(): LiveData<String> {
        return settingUseCase.getSortBySetting().asLiveData()
    }
    fun saveSortOrderSetting(isDescending: Boolean){
        settingUseCase.saveSortOrderSetting(isDescending)
    }
    fun saveSortBySetting(sortBy: String){
        settingUseCase.saveSortBySetting(sortBy)
    }
}