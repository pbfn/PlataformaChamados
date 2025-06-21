package com.pedro.plataformachamados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pedro.plataformachamados.data.global_state.UserStateHolder
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
import org.koin.android.ext.android.inject
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

                val userStateHolder: UserStateHolder by inject()

                val loginUiState = loginViewModel.uiState.collectAsState()
                val registerUiState = registerViewModel.registerUiState.collectAsState()
                val splashUiState = splashViewModel.state.collectAsState()
                val homeUiState = homeViewModel.state.collectAsState()
                val userState = userStateHolder.userState.collectAsState()

                val currentBackStackEntry = navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry.value?.destination?.route

                val finishLoadSplash = remember { mutableStateOf(false) }

                LaunchedEffect(userState.value.isLoggedIn, currentRoute, finishLoadSplash.value) {
                    val isOnSplash = currentRoute == Splash::class.simpleName
                    if (!userState.value.isLoggedIn &&
                        !isOnSplash &&
                        currentRoute != Login::class.simpleName &&
                        currentRoute != Register::class.simpleName
                        && finishLoadSplash.value
                    ) {
                        navController.navigate(Login) {
                            popUpTo(0) { inclusive = true }
                        }
                    }else {
                        if(userState.value.isLoggedIn){
                            navController.navigate(Home) {
                                popUpTo(Login) { inclusive = true }
                            }
                        }
                    }
                }

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
                            onSplashFinished = {
                                finishLoadSplash.value = true
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
