package com.pedro.services.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro.services.events.ListServiceUiEvents
import com.pedro.services.mapper.toUI
import com.pedro.services.model.ServiceDomain
import com.pedro.services.model.ServiceUI
import com.pedro.services.states.ListServiceUiState
import com.pedro.services.usecases.GetAllServicesUseCase
import com.pedro.services.usecases.SaveServiceUseCase
import com.pedro.services.usecases.UpdateServiceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListServicesViewModel(
    private val getAllServicesUseCase: GetAllServicesUseCase,
    private val saveServiceUseCase: SaveServiceUseCase,
    private val updateServiceUseCase: UpdateServiceUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<ListServiceUiState>(ListServiceUiState.Loading)
    val state: StateFlow<ListServiceUiState> = _state.asStateFlow()


    fun onEvent(event: ListServiceUiEvents) {
        viewModelScope.launch {
            when (event) {
                ListServiceUiEvents.OnLoadServices -> onLoadServices()
                is ListServiceUiEvents.OnChangeStatusService -> {
                    onChangeStatusService(event.serviceUI)
                }

                is ListServiceUiEvents.OnEditService -> {}
                ListServiceUiEvents.OnCreateService -> onClickCreateService()
                ListServiceUiEvents.OnDismissDialogCreateService -> onDismissDialogCreateService()
                ListServiceUiEvents.OnSaveService -> onSaveService()
                is ListServiceUiEvents.OnChangeServiceValue -> onChangeServiceValue(event.newValue)
                is ListServiceUiEvents.OnChangeServiceName -> onChangeServiceName(event.newValue)
            }
        }
    }

    private suspend fun onLoadServices() {
        _state.value = ListServiceUiState.Loading
        getAllServicesUseCase.invoke().collect { retorno ->
            val list = retorno.map { item ->
                item.toUI()
            }
            _state.value = ListServiceUiState.Success(listServices = list)
        }
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

    private suspend fun onSaveService() {
        val currentState = _state.value
        if (currentState is ListServiceUiState.Success) {
            val valorDouble = currentState.serviceValue
                .filter { it.isDigit() }
                .toDoubleOrNull()?.div(100) ?: 0.0

            _state.update {
                currentState.copy(isSaving = true, showCreateServiceDialog = false)
            }


            saveServiceUseCase.invoke(
                serviceDomain = ServiceDomain(
                    id = "",
                    serviceName = currentState.serviceName,
                    serviceValue = valorDouble,
                    isActivity = true
                )
            )

            onLoadServices()
        }
    }

    private fun onChangeServiceValue(newValue: String) {
        val digitsOnly = newValue.filter { it.isDigit() }

        val state = _state.value
        if (state is ListServiceUiState.Success) {
            _state.value = state.copy(serviceValue = digitsOnly)
        }

    }

    private fun onChangeServiceName(newValue: String) {
        val state = _state.value
        if (state is ListServiceUiState.Success) {
            _state.value = state.copy(serviceName = newValue)
        }

    }

    private suspend fun onChangeStatusService(serviceUI: ServiceUI) {
        _state.update { currentState ->
            when (currentState) {
                is ListServiceUiState.Success -> {
                    currentState.copy(isSaving = true, showCreateServiceDialog = false)
                }

                else -> currentState
            }
        }
        val newStatus = !serviceUI.isActive
        updateServiceUseCase.invoke(
            serviceDomain = ServiceDomain(
                id = serviceUI.id,
                serviceName = serviceUI.title,
                serviceValue = serviceUI.value,
                isActivity = newStatus
            )
        )
        onLoadServices()
    }
}