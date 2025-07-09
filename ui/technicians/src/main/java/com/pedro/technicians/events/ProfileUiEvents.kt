package com.pedro.technicians.events

import com.pedro.technicians.model.HoursType

sealed class ProfileUiEvents {
    data class OnChangeName(val name: String) : ProfileUiEvents()
    data class OnChangeEmail(val email: String) : ProfileUiEvents()
    data class OnChangePassword(val password: String) : ProfileUiEvents()
    data class OnSetInitialScreen(val isEditing: Boolean, val technicianId: Int) : ProfileUiEvents()
    data class OnSelectedHour(val selectedHour: String, val hoursType: HoursType) : ProfileUiEvents()
    data object OnSaveTechnician : ProfileUiEvents()
    data object TechnicianSaved : ProfileUiEvents()
}