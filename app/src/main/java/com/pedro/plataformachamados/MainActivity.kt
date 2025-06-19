package com.pedro.plataformachamados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.pedro.plataformachamados.ui.screens.login.LoginScreen
import com.pedro.plataformachamados.ui.screens.login.LoginViewModel
import com.pedro.plataformachamados.ui.theme.PlataformaChamadosTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val loginViewModel: LoginViewModel by viewModel()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlataformaChamadosTheme {

                val loginUiState = loginViewModel.uiState.collectAsState()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding),
                        onEvent = loginViewModel::onEvent,
                        state = loginUiState.value
                    )
                }
            }
        }
    }
}
