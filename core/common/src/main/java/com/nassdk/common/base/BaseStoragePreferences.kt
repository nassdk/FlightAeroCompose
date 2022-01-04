package com.nassdk.common.base

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.nassdk.common.extensions.ifNull
import java.io.IOException
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

/**
 * Базовый класс для хранения данных. Принимает два параметра при наследовании:
 * @param preferencesName - Ключевое название для создания хранилища
 * @param context - Контекст
 *
 * Этот класс не предназначен для создания инстансов - по этой причине класс абстрактный,
 * хоть и нет абстраных методов и переменных.
 *
 * От него небоходимо наследоваться.
 *
 * В классе реализовано сохранение только примитов и строк, для других целей
 * расширение писать в своей конкретной реализации.
 */
@Suppress("UnnecessaryAbstractClass")
abstract class BaseStoragePreferences(val preferencesName: String, val context: Context) {

    protected val Context.dataStore by preferencesDataStore(name = preferencesName)

    protected suspend fun putString(key: String, value: String) {

        context.dataStore.edit { preferences ->
            preferences[stringPreferencesKey(name = key)] = value
        }
    }

    protected suspend fun readString(key: String, defaultValue: String?): String? =
        context.dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else throw exception

            }.map { preferences ->
                preferences[stringPreferencesKey(name = key)].ifNull(defaultValue)
            }.firstOrNull()

    protected suspend fun putInt(key: String, value: Int) {

        context.dataStore.edit { preferences ->
            preferences[intPreferencesKey(name = key)] = value
        }
    }

    protected suspend fun readInt(key: String, defaultValue: Int?): Int? = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else throw exception

        }.map { preferences ->
            preferences[intPreferencesKey(name = key)].ifNull(defaultValue)
        }.firstOrNull()


    protected suspend fun putBoolean(key: String, value: Boolean) {

        context.dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(name = key)] = value
        }
    }

    protected suspend fun readBoolean(key: String, defaultValue: Boolean?): Boolean? =
        context.dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else throw exception

            }.map { preferences ->
                preferences[booleanPreferencesKey(name = key)].ifNull(defaultValue)
            }.firstOrNull()

    protected suspend fun clearPreferences() {

        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}