package com.pedro.services.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro.services.events.ListServiceUiEvents
import com.pedro.services.model.mockedListServices
import com.pedro.services.states.ListServiceUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListServicesViewModel : ViewModel() {

    private val _state = MutableStateFlow<ListServiceUiState>(ListServiceUiState.Loading)
    val state: StateFlow<ListServiceUiState> = _state.asStateFlow()


    fun onEvent(event: ListServiceUiEvents) {
        when (event) {
            ListServiceUiEvents.OnLoadServices -> onLoadServices()
            is ListServiceUiEvents.OnChangeStatusService -> {}
            is ListServiceUiEvents.OnEditService -> {}
            ListServiceUiEvents.OnCreateService -> {}
        }

    }

    private fun onLoadServices() {
        viewModelScope.launch {
            _state.value = ListServiceUiState.Loading
            _state.value = ListServiceUiState.Success(
                listServices = mockedListServices
            )
        }
    }
}