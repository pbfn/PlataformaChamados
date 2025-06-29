package com.pedro.plataformachamados.ui.navigation.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pedro.plataformachamados.ui.screens.admin.technicians.list.TechnicianScreen

fun NavGraphBuilder.technicianScreen(
    onNavigateToAddTechnician: () -> Unit
){
    composable(DrawerHomeAdminDestinations.Technicians.route) {
        TechnicianScreen(
            onClickAddTechnician = onNavigateToAddTechnician
        )
    }
}

fun NavHostController.navigateToTechnicianScreen(
    navOptions: NavOptions? = null
) {
    navigate(DrawerHomeAdminDestinations.Technicians.route, navOptions)
}