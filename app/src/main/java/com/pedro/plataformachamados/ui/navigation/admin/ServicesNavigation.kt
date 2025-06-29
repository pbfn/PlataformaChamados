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

fun NavGraphBuilder.servicesScreen() {
    composable(DrawerHomeAdminDestinations.Services.route) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Services")
        }
    }
}

fun NavHostController.navigateToServicesScreen(
    navOptions: NavOptions? = null
) {
    navigate(DrawerHomeAdminDestinations.Services.route, navOptions)
}