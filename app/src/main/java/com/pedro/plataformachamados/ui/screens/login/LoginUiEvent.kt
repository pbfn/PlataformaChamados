package com.pedro.plataformachamados.ui.screens.login

sealed class LoginUiEvent {
    data class OnEmailChanged(val email: String) : LoginUiEvent()
    data class OnPasswordChanged(val password: String) : LoginUiEvent()
    data object OnDoLogin : LoginUiEvent()
}