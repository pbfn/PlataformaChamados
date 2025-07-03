package com.pedro.technicians.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro.technicians.GetTechnicianByIdUseCase
import com.pedro.technicians.events.ProfileUiEvents
import com.pedro.technicians.mapper.toUI
import com.pedro.technicians.model.TechnicianUI
import com.pedro.technicians.states.profile.BoxOpeningHoursUiState
import com.pedro.technicians.states.profile.BoxPersonalDataUiState
import com.pedro.technicians.states.profile.ProfileUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileScreenViewModel(
    private val getTechnicianByIdUseCase: GetTechnicianByIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val state: StateFlow<ProfileUiState> = _state.asStateFlow()

    fun onEvent(event: ProfileUiEvents) {
        when (event) {
            is ProfileUiEvents.OnChangeEmail -> onEmailChanged(event.email)
            is ProfileUiEvents.OnChangeName -> onNameChanged(event.name)
            is ProfileUiEvents.OnChangePassword -> onPasswordChanged(event.password)
            ProfileUiEvents.OnLoadGenericHours -> {}
            ProfileUiEvents.OnLoadTechHours -> {}
            is ProfileUiEvents.OnSetInitialScreen -> onSetInitialScreen(
                event.isEditing,
                event.technicianId
            )
        }
    }


    private fun onEmailChanged(newEmail: String) {
        _state.update { currentState ->
            when (currentState) {
                is ProfileUiState.Success -> currentState.copy(
                    boxPersonalDataUiState = currentState.boxPersonalDataUiState.copy(
                        email = newEmail
                    )
                )

                else -> currentState
            }
        }
    }

    private fun onPasswordChanged(newPassword: String) {
        _state.update { currentState ->
            when (currentState) {
                is ProfileUiState.Success -> currentState.copy(
                    boxPersonalDataUiState = currentState.boxPersonalDataUiState.copy(
                        password = newPassword
                    )
                )

                else -> currentState
            }
        }
    }

    private fun onNameChanged(newName: String) {
        _state.update { currentState ->
            when (currentState) {
                is ProfileUiState.Success -> currentState.copy(
                    boxPersonalDataUiState = currentState.boxPersonalDataUiState.copy(
                        name = newName
                    )
                )

                else -> currentState
            }
        }
    }

    private suspend fun onLoadGenericHours(): BoxOpeningHoursUiState = withContext(Dispatchers.IO) {
        delay(2000L)
        val listMorningHours = listOf("07:00", "08:00", "09:00", "10:00", "11:00", "12:00")
        val listAfternoonHours = listOf("13:00", "14:00", "15:00", "16:00", "17:00", "18:00")
        val listNightHours = listOf("19:00", "20:00", "21:00", "22:00", "23:00")

        BoxOpeningHoursUiState(
            listMorningHours = listMorningHours,
            listAfternoonHours = listAfternoonHours,
            listNightHours = listNightHours
        )
    }

    private fun onSetInitialScreen(isEditing: Boolean, technicianId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            var technician: TechnicianUI? = null
            if (isEditing) {
                technician = onLoadTechnicianById(technicianId)
            }
            var boxOpeningHoursUiState = onLoadGenericHours()
            var boxPersonalDataUiState = BoxPersonalDataUiState(isEdit = isEditing)
            if (technician != null) {
                boxOpeningHoursUiState =
                    boxOpeningHoursUiState.copy(
                        listMorningSelected = technician.availabilities
                    )
                boxPersonalDataUiState = boxPersonalDataUiState.copy(
                    name = technician.name,
                    email = technician.email,
                    isEdit = true
                )
            }
            onSetupSuccess(boxOpeningHoursUiState, boxPersonalDataUiState, technicianId)
        }
    }

    private suspend fun onLoadTechnicianById(id: Int): TechnicianUI? = withContext(Dispatchers.IO) {
        getTechnicianByIdUseCase.invoke(id)
            .firstOrNull()
            ?.toUI()
    }

    private fun onSetupSuccess(
        boxOpeningHoursUiState: BoxOpeningHoursUiState,
        boxPersonalDataUiState: BoxPersonalDataUiState,
        technicianId: Int
    ) {
        _state.value = ProfileUiState.Success(
            technicianSelectedID = technicianId,
            boxPersonalDataUiState = boxPersonalDataUiState,
            boxOpeningHoursUiState = boxOpeningHoursUiState
        )
    }

}