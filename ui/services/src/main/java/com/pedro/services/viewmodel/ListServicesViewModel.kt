package com.pedro.services.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro.services.events.ListServiceUiEvents
import com.pedro.services.model.mockedListServices
import com.pedro.services.states.ListServiceUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListServicesViewModel : ViewModel() {

    private val _state = MutableStateFlow<ListServiceUiState>(ListServiceUiState.Loading)
    val state: StateFlow<ListServiceUiState> = _state.asStateFlow()


    fun onEvent(event: ListServiceUiEvents) {
        viewModelScope.launch {
            when (event) {
                ListServiceUiEvents.OnLoadServices -> onLoadServices()
                is ListServiceUiEvents.OnChangeStatusService -> {}
                is ListServiceUiEvents.OnEditService -> {}
                ListServiceUiEvents.OnCreateService -> onClickCreateService()
                ListServiceUiEvents.OnDismissDialogCreateService -> onDismissDialogCreateService()
                ListServiceUiEvents.OnSaveService -> onSaveService()
            }
        }
    }

    private fun onLoadServices() {
        _state.value = ListServiceUiState.Loading
        _state.value = ListServiceUiState.Success(
            listServices = mockedListServices
        )
    }

    private fun onClickCreateService() {
        _state.update { currentState ->
            when (currentState) {
                is ListServiceUiState.Success -> {
                    currentState.copy(showCreateServiceDialog = true)
                }

                else -> currentState
            }
        }
    }

    private fun onDismissDialogCreateService() {
        _state.update { currentState ->
            when (currentState) {
                is ListServiceUiState.Success -> {
                    currentState.copy(showCreateServiceDialog = false)
                }

                else -> currentState
            }
        }
    }

    private fun onSaveService() {
        _state.update { currentState ->
            when (currentState) {
                is ListServiceUiState.Success -> {
                    currentState.copy(isSaving = true)
                }

                else -> currentState
            }
        }
    }
}