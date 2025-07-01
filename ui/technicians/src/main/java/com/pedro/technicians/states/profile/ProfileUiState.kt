package com.pedro.technicians.states.profile

data class ProfileUiState(
    val boxPersonalDataUiState: BoxPersonalDataUiState = BoxPersonalDataUiState(),
    val boxOpeningHoursUiState: BoxOpeningHoursUiState = BoxOpeningHoursUiState(),
)


