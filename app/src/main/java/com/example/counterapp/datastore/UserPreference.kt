package com.example.counterapp.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.counterapp.model.LanguageConfig
import com.example.counterapp.model.ThemeConfig
import com.example.counterapp.model.UserConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreference @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    val userData: Flow<UserConfig> = dataStore.data.map {
        UserConfig(
            language = enumValues<LanguageConfig>().firstOrNull { config ->
                config.name == it[LANGUAGE_KEY]
            } ?: UserConfig.default().language,
            themeConfig = enumValues<ThemeConfig>().firstOrNull { config ->
                config.name == it[THEME_KEY]
            } ?: UserConfig.default().themeConfig
        )
    }

    suspend fun setLanguageConfig(languageConfig: LanguageConfig) {
        dataStore.edit {
            it[LANGUAGE_KEY] = languageConfig.name
        }
    }

    suspend fun setThemeConfig(themeConfig: ThemeConfig) {
        dataStore.edit {
            it[THEME_KEY] = themeConfig.name
        }
    }

    private companion object {
        private val LANGUAGE_KEY = stringPreferencesKey("language")
        private val THEME_KEY = stringPreferencesKey("theme")
    }
}
