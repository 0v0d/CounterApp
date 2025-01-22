package com.example.counterapp.repository

import com.example.counterapp.datastore.UserPreference
import com.example.counterapp.model.LanguageConfig
import com.example.counterapp.model.ThemeConfig
import com.example.counterapp.model.UserConfig
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface UserDataRepository {
    val userConfig: Flow<UserConfig>
    suspend fun setThemeConfig(themeConfig: ThemeConfig)
    suspend fun setLanguageConfig(languageConfig: LanguageConfig)
}

class UserDataRepositoryImpl @Inject constructor(
    private val userPreference: UserPreference
) : UserDataRepository {
    override val userConfig: Flow<UserConfig> = userPreference.userData

    override suspend fun setLanguageConfig(languageConfig: LanguageConfig) {
        userPreference.setLanguageConfig(languageConfig)
    }

    override suspend fun setThemeConfig(themeConfig: ThemeConfig) {
        userPreference.setThemeConfig(themeConfig)
    }
}
