package com.pedro.technicians.events

sealed class ProfileUiEvents {
    data class OnChangeName(val name: String) : ProfileUiEvents()
    data class OnChangeEmail(val email: String) : ProfileUiEvents()
    data class OnChangePassword(val password: String) : ProfileUiEvents()
    data class OnSetInitialScreen(val isEditing: Boolean,val technicianId: Int) : ProfileUiEvents()
    data object OnLoadGenericHours : ProfileUiEvents()
    data object OnLoadTechHours : ProfileUiEvents()
}