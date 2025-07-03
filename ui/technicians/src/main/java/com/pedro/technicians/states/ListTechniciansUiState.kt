package com.pedro.technicians.states

import com.pedro.technicians.model.TechnicianUI

sealed class ListTechniciansUiState {
    object Loading : ListTechniciansUiState()
    data class Success
        (val listTechnicians: List<TechnicianUI> = listOf()) : ListTechniciansUiState()

    data class Error(val message: String) : ListTechniciansUiState()
}
