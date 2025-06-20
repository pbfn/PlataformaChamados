package com.pedro.plataformachamados.ui.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro.plataformachamados.repositories.AuthFirebaseRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    private val firebaseRepository: AuthFirebaseRepository
) : ViewModel() {

    private val _state = MutableStateFlow<SplashScreenUiState>(SplashScreenUiState.Loading)
    val state: StateFlow<SplashScreenUiState> = _state


    fun onEvent(event: SplashUiEvent){
        when(event){
            SplashUiEvent.OnVerifyIsLogged -> onVerifyIsLogged()
        }
    }

    private fun onVerifyIsLogged(){
        viewModelScope.launch {
            delay(3000L)
            val isLoggedIn = firebaseRepository.isLoggedIn()
            _state.value = SplashScreenUiState.Success(isLogged = isLoggedIn)
        }
    }

}