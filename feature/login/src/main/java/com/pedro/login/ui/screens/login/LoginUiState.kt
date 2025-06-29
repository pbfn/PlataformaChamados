package com.pedro.login.ui.screens.login

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailHasError: Boolean = false,
    val passwordHasError: Boolean = false,
    val helperTextEmail: String = "",
    val helperTextPassword: String = ""
)
