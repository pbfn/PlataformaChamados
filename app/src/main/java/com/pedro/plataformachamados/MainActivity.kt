package com.pedro.plataformachamados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pedro.plataformachamados.ui.navigation.authGraph
import com.pedro.plataformachamados.ui.navigation.homeGraph
import com.pedro.plataformachamados.ui.navigation.navigateToAuthGraph
import com.pedro.plataformachamados.ui.navigation.navigateToHomeGraph
import com.pedro.plataformachamados.ui.navigation.navigateToLogin
import com.pedro.plataformachamados.ui.navigation.navigateToRegister
import com.pedro.plataformachamados.ui.navigation.splashScreen
import com.pedro.plataformachamados.ui.navigation.splashScreenRoute
import com.pedro.plataformachamados.ui.theme.PlataformaChamadosTheme
import data.global_state.AppViewModel
import model.AppState
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            PlataformaChamadosTheme {

                val navController = rememberNavController()
                val appViewModel = koinViewModel<AppViewModel>()
                val appState by appViewModel.state.collectAsState(initial = AppState())


                LaunchedEffect(appState) {
                    if (appState.isInitLoading) {
                        return@LaunchedEffect
                    }
                    appState.user?.let {
                        navController.navigateToHomeGraph()
                    } ?: navController.navigateToAuthGraph()

                }

                NavHost(
                    navController = navController,
                    startDestination = splashScreenRoute
                ) {

                    splashScreen()

                    authGraph(
                        onNavigateToRegister = {
                            navController.navigateToRegister()
                        },
                        onNavigateLogin = {
                            navController.navigateToLogin(it)
                        }
                    )

                    homeGraph(
                        onPopBackStack = {
                            navController.popBackStack()
                        }
                    )

                }
            }
        }
    }
}
