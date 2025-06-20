package com.pedro.plataformachamados.ui.screens.register

import androidx.lifecycle.ViewModel
import com.pedro.plataformachamados.ui.utils.isValidEmail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {

    private val _registerUiState = MutableStateFlow(RegisterUiState())
    val registerUiState: StateFlow<RegisterUiState> = _registerUiState.asStateFlow()

    fun onEvent(event: RegisterUiEvent) {
        when (event) {
            RegisterUiEvent.OnDoRegister -> onValidateRegister()
            is RegisterUiEvent.OnEmailChanged -> onEmailChanged(event.email)
            is RegisterUiEvent.OnNameChanged -> onNameChanged(event.name)
            is RegisterUiEvent.OnPasswordChanged -> onPasswordChanged(event.password)
        }
    }


    private fun onEmailChanged(newEmail: String) {
        _registerUiState.update { currentState ->
            currentState.copy(
                email = newEmail
            )
        }
    }

    private fun onPasswordChanged(newPassword: String) {
        _registerUiState.update { currentState ->
            currentState.copy(
                password = newPassword
            )
        }
    }

    private fun onNameChanged(newName: String) {
        _registerUiState.update { currentState ->
            currentState.copy(
                name = newName
            )
        }
    }

    private fun onValidateRegister() {
        val email = _registerUiState.value.email
        val password = _registerUiState.value.password
        val name = _registerUiState.value.name

        val emailError = validateEmail(email)
        val passwordError = validatePassword(password)
        val nameError = validateName(name)

        _registerUiState.update { current ->
            current.copy(
                emailHasError = emailError != null,
                helperTextEmail = emailError.orEmpty(),
                passwordHasError = passwordError != null,
                helperTextPassword = passwordError.orEmpty(),
                nameHasError = nameError != null,
                helperTextName = nameError.orEmpty()
            )
        }

        val hasError = emailError != null || passwordError != null || nameError != null
        if (!hasError) {
            // TODO: navegar para próxima tela
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
        return when {
            password.isBlank() -> "Senha não pode ser vazia!"
            password.length < 6 -> "Senha deve ter no mínimo 6 dígitos"
            else -> null
        }
    }

    private fun validateName(name: String): String? {
        return if (name.isBlank()) "Nome não pode ser vazio!" else null
    }
}