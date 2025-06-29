package com.pedro.register_user.ui.screens.register_user

data class RegisterUiState(
    val email: String = "",
    val password: String = "",
    val name: String = "",
    val emailHasError: Boolean = false,
    val passwordHasError: Boolean = false,
    val nameHasError: Boolean = false,
    val helperTextEmail: String = "",
    val helperTextPassword: String = "Mínimo de 6 dígitos",
    val helperTextName: String = ""
)
