package com.pedro.technicians.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro.technicians.GetTechnicianByIdUseCase
import com.pedro.technicians.SaveTechnicianUseCase
import com.pedro.technicians.UpdateTechnicianUseCase
import com.pedro.technicians.events.ProfileUiEvents
import com.pedro.technicians.mapper.toUI
import com.pedro.technicians.model.HoursType
import com.pedro.technicians.model.TechnicianDomain
import com.pedro.technicians.model.TechnicianUI
import com.pedro.technicians.states.profile.BoxOpeningHoursUiState
import com.pedro.technicians.states.profile.BoxPersonalDataUiState
import com.pedro.technicians.states.profile.ProfileUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileScreenViewModel(
    private val getTechnicianByIdUseCase: GetTechnicianByIdUseCase,
    private val saveTechnicianUseCase: SaveTechnicianUseCase,
    private val updateTechnicianUseCase: UpdateTechnicianUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val state: StateFlow<ProfileUiState> = _state.asStateFlow()

    private val _eventFlow = MutableSharedFlow<ProfileUiEvents>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: ProfileUiEvents) {
        when (event) {
            is ProfileUiEvents.OnChangeEmail -> onEmailChanged(event.email)
            is ProfileUiEvents.OnChangeName -> onNameChanged(event.name)
            is ProfileUiEvents.OnChangePassword -> onPasswordChanged(event.password)
            is ProfileUiEvents.OnSetInitialScreen -> onSetInitialScreen(
                event.isEditing,
                event.technicianId
            )

            ProfileUiEvents.OnSaveTechnician -> onSaveTechnician()
            ProfileUiEvents.TechnicianSaved -> {}
            is ProfileUiEvents.OnSelectedHour -> onSelectedHour(event.selectedHour, event.hoursType)
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

    private fun onSetInitialScreen(isEditing: Boolean, technicianId: String) {
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
                        listMorningSelected = technician.morningAvailabilities,
                        listAfternoonSelected = technician.afternoonAvailabilities,
                        listNightSelected = technician.nightAvailabilities
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

    private suspend fun onLoadTechnicianById(id: String): TechnicianUI? = withContext(Dispatchers.IO) {
        getTechnicianByIdUseCase.invoke(id)
            .firstOrNull()
            ?.toUI()
    }

    private fun onSetupSuccess(
        boxOpeningHoursUiState: BoxOpeningHoursUiState,
        boxPersonalDataUiState: BoxPersonalDataUiState,
        technicianId: String
    ) {
        _state.value = ProfileUiState.Success(
            technicianSelectedID = technicianId,
            boxPersonalDataUiState = boxPersonalDataUiState,
            boxOpeningHoursUiState = boxOpeningHoursUiState
        )
    }

    fun onSaveTechnician() {
        viewModelScope.launch {
            val currentState = state.value
            when (currentState) {
                is ProfileUiState.Success -> {
                    val name = currentState.boxPersonalDataUiState.name
                    val email = currentState.boxPersonalDataUiState.email
                    val password = currentState.boxPersonalDataUiState.password
                    val morningAvailabilities = currentState.boxOpeningHoursUiState.listMorningSelected
                    val afternoonAvailabilities = currentState.boxOpeningHoursUiState.listAfternoonSelected
                    val nightAvailabilities = currentState.boxOpeningHoursUiState.listNightSelected
                    val isEdit = currentState.boxPersonalDataUiState.isEdit

                    if (isEdit) {
                        updateTechnicianUseCase.invoke(
                            technicianDomain = TechnicianDomain(
                                id = currentState.technicianSelectedID,
                                name = name,
                                email = email,
                                password = password,
                                morningAvailabilities = morningAvailabilities,
                                afternoonAvailabilities = afternoonAvailabilities,
                                nightAvailabilities = nightAvailabilities,
                            )
                        )
                    } else {
                        saveTechnicianUseCase.invoke(
                            technicianDomain = TechnicianDomain(
                                name = name,
                                email = email,
                                password = password,
                                morningAvailabilities = morningAvailabilities,
                                afternoonAvailabilities = afternoonAvailabilities,
                                nightAvailabilities = nightAvailabilities,
                            )
                        )
                    }

                    _eventFlow.emit(ProfileUiEvents.TechnicianSaved)
                }
                else -> {}
            }
        }

    }

    private fun onSelectedHour(selectedHour: String, hoursType: HoursType) {
        _state.update { currentState ->
            if (currentState is ProfileUiState.Success) {
                val boxState = currentState.boxOpeningHoursUiState

                val updatedList = when (hoursType) {
                    HoursType.MORNING -> boxState.listMorningSelected
                    HoursType.AFTERNOON -> boxState.listAfternoonSelected
                    HoursType.NIGHT -> boxState.listNightSelected
                }.let { list ->
                    if (list.contains(selectedHour)) list - selectedHour
                    else list + selectedHour
                }

                val updatedBoxState = when (hoursType) {
                    HoursType.MORNING -> boxState.copy(listMorningSelected = updatedList)
                    HoursType.AFTERNOON -> boxState.copy(listAfternoonSelected = updatedList)
                    HoursType.NIGHT -> boxState.copy(listNightSelected = updatedList)
                }

                currentState.copy(boxOpeningHoursUiState = updatedBoxState)
            } else {
                currentState
            }
        }
    }

}