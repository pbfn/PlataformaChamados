package com.pedro.technicians.viewmodel

import androidx.lifecycle.ViewModel
import com.pedro.technicians.states.ListTechniciansUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ListTechniciansViewModel : ViewModel() {

    private val _state = MutableStateFlow(ListTechniciansUiState())
    val state: StateFlow<ListTechniciansUiState> = _state.asStateFlow()
}