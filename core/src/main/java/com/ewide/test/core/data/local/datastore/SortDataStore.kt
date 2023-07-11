package com.ewide.test.core.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SortDataStore(
    context: Context
) {

    private val Context.dataStore by preferencesDataStore(PREF_SETTINGS)
    private val sortKey = booleanPreferencesKey(PREF_SORT)
    private val settingDataStore = context.dataStore

    fun getSortSetting(): Flow<Boolean> {
        return settingDataStore.data.map {
            it[sortKey] ?: false
        }
    }

    suspend fun saveSortSetting(isDescending: Boolean) {
        settingDataStore.edit {
            it[sortKey] = isDescending
        }
    }

    companion object{
        const val PREF_SETTINGS = "pref_settings"
        const val PREF_SORT = "pref_sort"
    }

}