package com.pedro.technicians.viewmodel

import androidx.lifecycle.ViewModel
import com.pedro.technicians.events.ProfileUiEvents
import com.pedro.technicians.states.profile.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileScreenViewModel : ViewModel() {

    private val _state = MutableStateFlow(ProfileUiState())
    val state: StateFlow<ProfileUiState> = _state.asStateFlow()

    fun onEvent(event: ProfileUiEvents) {
        when (event) {
            is ProfileUiEvents.OnChangeEmail -> onEmailChanged(event.email)
            is ProfileUiEvents.OnChangeName -> onNameChanged(event.name)
            is ProfileUiEvents.OnChangePassword -> onPasswordChanged(event.password)
            ProfileUiEvents.OnLoadGenericHours -> onLoadGenericHours()
            ProfileUiEvents.OnLoadTechHours -> onLoadTechHours()
            is ProfileUiEvents.OnSetInitialScreen -> onSetInitialScreen(
                event.isEditing,
                event.technicianId
            )
        }
    }


    private fun onEmailChanged(newEmail: String) {
        _state.update { currentState ->
            currentState.copy(
                boxPersonalDataUiState = currentState.boxPersonalDataUiState.copy(
                    email = newEmail
                )
            )
        }
    }

    private fun onPasswordChanged(newPassword: String) {
        _state.update { currentState ->
            currentState.copy(
                boxPersonalDataUiState = currentState.boxPersonalDataUiState.copy(
                    password = newPassword
                )
            )
        }
    }

    private fun onNameChanged(newName: String) {
        _state.update { currentState ->
            currentState.copy(
                boxPersonalDataUiState = currentState.boxPersonalDataUiState.copy(
                    name = newName
                )
            )
        }
    }

    private fun onLoadGenericHours() {
        val listMorningHours = listOf<String>("07:00", "08:00", "09:00", "10:00", "11:00", "12:00")
        val listAfternoonHours =
            listOf<String>("13:00", "14:00", "15:00", "16:00", "17:00", "18:00")
        val listNightHours = listOf<String>("19:00", "20:00", "21:00", "22:00", "23:00")
        _state.update { currentState ->
            currentState.copy(
                boxOpeningHoursUiState = currentState.boxOpeningHoursUiState.copy(
                    listMorningHours = listMorningHours,
                    listAfternoonHours = listAfternoonHours,
                    listNightHours = listNightHours
                )
            )
        }
    }

    private fun onLoadTechHours() {
        val listMorningSelected = listOf<String>("07:00", "08:00", "11:00", "12:00")
        val listAfternoonSelected = listOf<String>("14:00", "15:00")
        val listNightSelected = listOf<String>("23:00")
        _state.update { currentState ->
            currentState.copy(
                boxOpeningHoursUiState = currentState.boxOpeningHoursUiState.copy(
                    listMorningSelected = listMorningSelected,
                    listAfternoonSelected = listAfternoonSelected,
                    listNightSelected = listNightSelected
                )
            )
        }
    }

    private fun onSetInitialScreen(isEditing: Boolean, technicianId: Int) {
        _state.update { currentState ->
            currentState.copy(
                boxPersonalDataUiState = currentState.boxPersonalDataUiState.copy(
                    isEdit = isEditing
                ),
                technicianSelectedID = technicianId
            )
        }
    }

}