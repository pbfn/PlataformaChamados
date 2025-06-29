package com.pedro.plataformachamados.ui.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pedro.login.ui.screens.login.LoginScreen
import com.pedro.login.ui.screens.login.LoginViewModel
import org.koin.androidx.compose.koinViewModel


const val loginRoute: String = "login"

fun NavGraphBuilder.loginScreen(
    onNavigateToRegister: () -> Unit
) {
    composable(loginRoute) {
        val viewModel = koinViewModel<LoginViewModel>()
        val state by viewModel.uiState.collectAsState()
        LoginScreen(
            modifier = Modifier,
            onEvent = viewModel::onEvent,
            state = state,
            navigateToCreateAccount = onNavigateToRegister
        )
    }
}

fun NavHostController.navigateToLogin(
    navOptions: NavOptions? = null
) {
    navigate(loginRoute, navOptions)
}