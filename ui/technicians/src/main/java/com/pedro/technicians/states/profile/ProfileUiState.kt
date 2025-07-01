package com.pedro.technicians.states.profile

data class ProfileUiState(
    val technicianSelectedID: Int = 0,
    val boxPersonalDataUiState: BoxPersonalDataUiState = BoxPersonalDataUiState(),
    val boxOpeningHoursUiState: BoxOpeningHoursUiState = BoxOpeningHoursUiState(),
)


