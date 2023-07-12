package com.ewide.test.core.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SortDataStore(
    context: Context
) {

    private val Context.dataStore by preferencesDataStore(PREF_SETTINGS)
    private val sortOrderKey = booleanPreferencesKey(PREF_SORT_ORDER)
    private val sortByKey = stringPreferencesKey(PREF_SORT_BY)
    private val settingDataStore = context.dataStore

    fun getSortOrderSetting(): Flow<Boolean> {
        return settingDataStore.data.map {
            it[sortOrderKey] ?: false
        }
    }

    fun getSortBySetting(): Flow<String>{
        return settingDataStore.data.map {
            it[sortByKey] ?: "title"
        }
    }

    suspend fun saveSortOrderSetting(isDescending: Boolean) {
        settingDataStore.edit {
            it[sortOrderKey] = isDescending
        }
    }

    suspend fun saveSortBySetting(sortBy: String) {
        settingDataStore.edit {
            it[sortByKey] = sortBy
        }
    }

    companion object{
        const val PREF_SETTINGS = "pref_settings"
        const val PREF_SORT_ORDER = "pref_sort_order"
        const val PREF_SORT_BY = "pref_sort_by"
    }

}