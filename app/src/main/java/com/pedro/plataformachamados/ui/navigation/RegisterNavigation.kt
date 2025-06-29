package com.pedro.plataformachamados.ui.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pedro.register_user.ui.screens.register_user.RegisterScreen
import com.pedro.register_user.ui.screens.register_user.RegisterViewModel
import org.koin.androidx.compose.koinViewModel


const val registerRoute: String = "register"

fun NavGraphBuilder.registerScreen(
    onNavigateToLogin: () -> Unit
) {
    composable(registerRoute) {
        val viewModel = koinViewModel<RegisterViewModel>()
        val state by viewModel.registerUiState.collectAsState()
        RegisterScreen(
            modifier = Modifier,
            navigateToLogin = onNavigateToLogin,
            state = state,
            onEvent = viewModel::onEvent
        )
    }
}

fun NavHostController.navigateToRegister(
    navOptions: NavOptions? = null
) {
    navigate(registerRoute, navOptions)
}