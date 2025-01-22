package com.example.counterapp.view.setting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.counterapp.model.UserConfig
import com.example.counterapp.ui.theme.CounterAppTheme
import com.example.counterapp.view.setting.component.SettingsContent
import com.example.counterapp.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val userConfig by viewModel.userConfig.collectAsState()
        SettingsContent(
            userConfig = userConfig,
            onChangeThemeConfig = { viewModel.setThemeConfig(it) },
            onChangeLanguageConfig = { viewModel.setLanguageConfig(it) }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    CounterAppTheme {
        SettingsContent(
            userConfig = UserConfig.default(),
            onChangeThemeConfig = { },
            onChangeLanguageConfig = { }
        )
    }
}
