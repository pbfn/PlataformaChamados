package com.pedro.services.states

import com.pedro.services.model.ServiceUI

sealed class ListServiceUiState {
    object Loading : ListServiceUiState()
    data class Success(val listServices: List<ServiceUI> = listOf()) : ListServiceUiState()

    data class Error(val message: String) : ListServiceUiState()
}
