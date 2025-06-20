package com.pedro.plataformachamados.ui.screens.splash

sealed class SplashScreenUiState {
    object Loading : SplashScreenUiState()
    data class Success(val isLogged: Boolean) : SplashScreenUiState()
    data class Error(val message: String) : SplashScreenUiState()
}