package com.pedro.plataformachamados.ui.navigation.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.navigation
import androidx.navigation.navOptions
import com.pedro.technicians.model.TechnicianUI

const val drawerHomeAdmGraphRoute = "drawerHomeAdmGraph"

fun NavGraphBuilder.drawerHomeAdmGraph(
    onNavigateToAddTechnician: () -> Unit,
    onNavigateToEditTechnician: (TechnicianUI) -> Unit
) {
    navigation(
        route = drawerHomeAdmGraphRoute,
        startDestination = DrawerHomeAdminDestinations.Ticket.route
    ) {

        ticketsScreen()

        technicianScreen(
            onNavigateToAddTechnician = onNavigateToAddTechnician,
            onNavigateToEditTechnician = { technician ->
                onNavigateToEditTechnician(technician)
            }
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