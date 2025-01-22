package com.example.counterapp.model

import kotlinx.serialization.Serializable

@Serializable
data class UserConfig(
    val language: LanguageConfig,
    val themeConfig: ThemeConfig,
) {
    companion object {
        fun default(): UserConfig {
            return UserConfig(
                language = LanguageConfig.English,
                themeConfig = ThemeConfig.System,
            )
        }
    }
}

enum class ThemeConfig {
    System,
    Light,
    Dark,
}

enum class LanguageConfig(val languageCode: String) {
    English("en"),
    Japanese("ja"),
}
