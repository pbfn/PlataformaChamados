package com.pedro.plataformachamados.ui.navigation.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pedro.services.model.mockedListServices
import com.pedro.services.screens.ListServiceScreen
import com.pedro.services.states.ListServiceUiState

fun NavGraphBuilder.servicesScreen() {
    composable(DrawerHomeAdminDestinations.Services.route) {
        ListServiceScreen(
            state = ListServiceUiState.Success(
                listServices = mockedListServices
            )
        )
    }
}

fun NavHostController.navigateToServicesScreen(
    navOptions: NavOptions? = null
) {
    navigate(DrawerHomeAdminDestinations.Services.route, navOptions)
}