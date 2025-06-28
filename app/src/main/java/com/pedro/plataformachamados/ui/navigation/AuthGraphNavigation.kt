package com.pedro.plataformachamados.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import androidx.navigation.navigation

const val authGraphRoute = "authGraph"

fun NavGraphBuilder.authGraph(
    onNavigateToRegister: () -> Unit,
    onNavigateLogin: (NavOptions) -> Unit
) {

    navigation(
        route = authGraphRoute,
        startDestination = loginRoute
    ) {
        loginScreen(
            onNavigateToRegister = onNavigateToRegister
        )
        registerScreen(
            onNavigateToLogin = {
                onNavigateLogin(navOptions {
                    popUpTo(authGraphRoute)
                })
            }
        )
    }
}

fun NavHostController.navigateToAuthGraph(
    navOptions: NavOptions? = navOptions {
        popUpTo(graph.id) {
            inclusive = true
        }
    }
) {
    navigate(authGraphRoute, navOptions)
}