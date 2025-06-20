package com.pedro.plataformachamados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pedro.plataformachamados.ui.route.Home
import com.pedro.plataformachamados.ui.route.Login
import com.pedro.plataformachamados.ui.route.Register
import com.pedro.plataformachamados.ui.route.Splash
import com.pedro.plataformachamados.ui.screens.admin.home.HomeScreen
import com.pedro.plataformachamados.ui.screens.admin.home.HomeViewModel
import com.pedro.plataformachamados.ui.screens.login.LoginScreen
import com.pedro.plataformachamados.ui.screens.login.LoginViewModel
import com.pedro.plataformachamados.ui.screens.register.RegisterScreen
import com.pedro.plataformachamados.ui.screens.register.RegisterViewModel
import com.pedro.plataformachamados.ui.screens.splash.SplashScreen
import com.pedro.plataformachamados.ui.screens.splash.SplashViewModel
import com.pedro.plataformachamados.ui.theme.PlataformaChamadosTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            PlataformaChamadosTheme {

                val navController = rememberNavController()

                val loginViewModel: LoginViewModel by viewModel()
                val registerViewModel: RegisterViewModel by viewModel()
                val splashViewModel: SplashViewModel by viewModel()
                val homeViewModel: HomeViewModel by viewModel()

                val loginUiState = loginViewModel.uiState.collectAsState()
                val registerUiState = registerViewModel.registerUiState.collectAsState()
                val splashUiState = splashViewModel.state.collectAsState()
                val homeUiState = homeViewModel.state.collectAsState()

                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            onNavigateToLogin = {
                                navController.navigate(Login) {
                                    popUpTo(Splash) { inclusive = true }
                                }
                            },
                            onNavigateToHome = {
                                navController.navigate(Home) {
                                    popUpTo(Splash) { inclusive = true }
                                }
                            },
                            state = splashUiState.value,
                            onEvent = splashViewModel::onEvent
                        )
                    }
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
                            },
                            state = registerUiState.value,
                            onEvent = registerViewModel::onEvent
                        )
                    }

                    composable<Home> {
                        //TODO Definir o tipo do usuário logado para definir para qual tela ele vai.
                        HomeScreen(
                            state = homeUiState.value,
                            onEvent = homeViewModel::onEvent
                        )
                    }
                }
            }
        }
    }
}
