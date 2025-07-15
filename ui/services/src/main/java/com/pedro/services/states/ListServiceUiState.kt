package com.pedro.services.states

import com.pedro.services.model.ServiceUI

sealed class ListServiceUiState {
    object Loading : ListServiceUiState()
    data class Success(
        val listServices: List<ServiceUI> = listOf(),
        val showCreateServiceDialog: Boolean = false,
        val isSaving: Boolean = false,
        val serviceName: String = "",
        val serviceValue: String = "",
    ) : ListServiceUiState()

    data class Error(val message: String) : ListServiceUiState()
}
