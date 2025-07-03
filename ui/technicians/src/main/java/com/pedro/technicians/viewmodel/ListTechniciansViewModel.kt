package com.pedro.technicians.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro.technicians.GetAllTechniciansUseCase
import com.pedro.technicians.mapper.toUI
import com.pedro.technicians.states.ListTechniciansUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListTechniciansViewModel(
    private val getSearchContentsUseCase: GetAllTechniciansUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<ListTechniciansUiState>(ListTechniciansUiState.Loading)
    val state: StateFlow<ListTechniciansUiState> = _state.asStateFlow()

    init {
        init()
    }

    fun init() {
        viewModelScope.launch {
            getSearchContentsUseCase.invoke().collect { retorno ->
                Log.d("getSearchContentsUseCase", "init: $retorno")
                val list = retorno.map { item ->
                    item.toUI()
                }
                _state.value = ListTechniciansUiState.Success(listTechnicians = list)
            }
        }
    }
}