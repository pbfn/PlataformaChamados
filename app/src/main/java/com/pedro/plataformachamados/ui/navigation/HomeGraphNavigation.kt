package com.pedro.plataformachamados.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import androidx.navigation.navigation

const val homeGraphRoute = "homeGraph"

fun NavGraphBuilder.homeGraph() {
    navigation(
        startDestination = homeAdmRoute,
        route = homeGraphRoute
    ) {
        homeAdmScreen()
    }
}

fun NavHostController.navigateToHomeGraph(
    navOptions: NavOptions? = navOptions {
        popUpTo(graph.id) {
            inclusive = true
        }
    }
) {
    navigate(homeGraphRoute, navOptions)
}