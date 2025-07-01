package com.pedro.technicians.states.profile

data class BoxPersonalDataUiState(
    val isEdit: Boolean = false,
    val name: String = "",
    val helperTextName: String = "",
    val nameHasError: Boolean = false,
    val email: String = "",
    val helperTextEmail: String = "",
    val emailHasError: Boolean = false,
    val password: String = "",
    val helperTextPassword: String = "",
    val passwordHasError: Boolean = false,
)
