package com.pedro.plataformachamados.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro.plataformachamados.repositories.AuthFirebaseRepository
import com.pedro.plataformachamados.ui.utils.isValidEmail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val firebaseRepository: AuthFirebaseRepository
) : ViewModel() {


    private val _loginUiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()


    fun onEvent(event: LoginUiEvent) {
        when (event) {
            is LoginUiEvent.OnEmailChanged -> onEmailChanged(event.email)
            is LoginUiEvent.OnPasswordChanged -> onPasswordChanged(event.password)
            LoginUiEvent.OnDoLogin -> onValidateLogin()
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

    private fun onValidateLogin() {
        val email = _loginUiState.value.email
        val password = _loginUiState.value.password

        val emailError = validateEmail(email)
        val passwordError = validatePassword(password)

        _loginUiState.update { current ->
            current.copy(
                emailHasError = emailError != null,
                helperTextEmail = emailError.orEmpty(),
                passwordHasError = passwordError != null,
                helperTextPassword = passwordError.orEmpty()
            )
        }

        val hasError = emailError != null || passwordError != null
        if (!hasError) {
            onLogin(email,password)
        }

    }


    private fun validateEmail(email: String): String? {
        return when {
            email.isBlank() -> "E-mail não pode ser vazio!"
            !isValidEmail(email) -> "Este e-mail não é válido!"
            else -> null
        }
    }

    private fun validatePassword(password: String): String? {
        return if (password.isBlank()) "Senha não pode ser vazia!" else null
    }

    private fun onLogin(email: String, password: String) {
        viewModelScope.launch {
            val retorno = firebaseRepository.login(
                email, password
            )
        }
    }
}