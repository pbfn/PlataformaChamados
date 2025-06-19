package com.pedro.plataformachamados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pedro.plataformachamados.ui.route.Login
import com.pedro.plataformachamados.ui.route.Register
import com.pedro.plataformachamados.ui.screens.login.LoginScreen
import com.pedro.plataformachamados.ui.screens.login.LoginViewModel
import com.pedro.plataformachamados.ui.screens.register.RegisterScreen
import com.pedro.plataformachamados.ui.theme.PlataformaChamadosTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlataformaChamadosTheme {

                val navController = rememberNavController()

                val loginViewModel: LoginViewModel by viewModel()
                val loginUiState = loginViewModel.uiState.collectAsState()

                NavHost(
                    navController = navController,
                    startDestination = Login
                ) {
                    composable<Login> {
                        LoginScreen(
                            modifier = Modifier,
                            onEvent = loginViewModel::onEvent,
                            state = loginUiState.value,
                            navigateToCreateAccount = {
                                navController.navigate(Register) {
                                    popUpTo(Login) { inclusive = true }
                                }
                            }
                        )
                    }

                    composable<Register> {
                        RegisterScreen(
                            modifier = Modifier,
                            navigateToLogin = {
                                navController.navigate(Login) {
                                    popUpTo(Register) { inclusive = true }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
