package com.pedro.technicians.states.profile


sealed class ProfileUiState {
    object Loading : ProfileUiState()
    data class Success(
        val technicianSelectedID: Int = 0,
        val boxPersonalDataUiState: BoxPersonalDataUiState = BoxPersonalDataUiState(),
        val boxOpeningHoursUiState: BoxOpeningHoursUiState = BoxOpeningHoursUiState(),
    ) : ProfileUiState()

    data class Error(val message: String) : ProfileUiState()
}


