package com.pedro.plataformachamados.ui.navigation.admin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

fun NavGraphBuilder.ticketsScreen() {
    composable(DrawerHomeAdminDestinations.Ticket.route) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Tickets")
        }
    }
}

fun NavHostController.navigateToTicketsScreen(
    navOptions: NavOptions? = null
) {
    navigate(DrawerHomeAdminDestinations.Ticket.route, navOptions)
}