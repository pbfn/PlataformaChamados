package com.pedro.plataformachamados.ui.screens.register

sealed class RegisterUiEvent {
    data class OnEmailChanged(val email: String) : RegisterUiEvent()
    data class OnPasswordChanged(val password: String) : RegisterUiEvent()
    data class OnNameChanged(val name: String) : RegisterUiEvent()
    data object OnDoRegister : RegisterUiEvent()
}