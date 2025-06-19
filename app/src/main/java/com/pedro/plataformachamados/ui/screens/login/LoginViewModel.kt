package com.pedro.plataformachamados.ui.screens.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {


    private val _loginUiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()


    fun onEvent(event: LoginUiEvent) {
        when (event) {
            is LoginUiEvent.OnEmailChanged -> onEmailChanged(event.email)
            is LoginUiEvent.OnPasswordChanged -> onPasswordChanged(event.password)
        }
    }

    private fun onEmailChanged(newEmail: String) {
        _loginUiState.update { currentState ->
            currentState.copy(
                email = newEmail
            )
        }
    }

    private fun onPasswordChanged(newPassword: String) {
        _loginUiState.update { currentState ->
            currentState.copy(
                password = newPassword
            )
        }
    }

}