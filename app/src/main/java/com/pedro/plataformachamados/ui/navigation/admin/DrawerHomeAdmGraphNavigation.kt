package com.pedro.plataformachamados.ui.navigation.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.navigation
import androidx.navigation.navOptions

const val drawerHomeAdmGraphRoute = "drawerHomeAdmGraph"

fun NavGraphBuilder.drawerHomeAdmGraph(
    onNavigateToAddTechnician: () -> Unit
) {
    navigation(
        route = drawerHomeAdmGraphRoute,
        startDestination = DrawerHomeAdminDestinations.Ticket.route
    ) {

        ticketsScreen()

        technicianScreen(
            onNavigateToAddTechnician = onNavigateToAddTechnician
        )

        servicesScreen()
    }
}

fun NavHostController.navigateToDrawerHomeAdmGraph(
    navOptions: NavOptions? = navOptions {
        popUpTo(graph.id) {
            inclusive = true
        }
    }
) {
    navigate(drawerHomeAdmGraphRoute, navOptions)
}