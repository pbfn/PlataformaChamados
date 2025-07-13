package com.pedro.plataformachamados.ui.navigation.admin

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pedro.services.events.ListServiceUiEvents
import com.pedro.services.screens.ListServiceScreen
import com.pedro.services.viewmodel.ListServicesViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.servicesScreen() {
    composable(DrawerHomeAdminDestinations.Services.route) {
        val viewModel = koinViewModel<ListServicesViewModel>()
        val state by viewModel.state.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.onEvent(ListServiceUiEvents.OnLoadServices)
        }
        ListServiceScreen(
            state = state,
            onClickChangeStatusService = {
                viewModel.onEvent(ListServiceUiEvents.OnChangeStatusService(it))
            },
            onClickEditService = {
                viewModel.onEvent(ListServiceUiEvents.OnEditService(it))
            },
            onCreateService = {
                viewModel.onEvent(ListServiceUiEvents.OnCreateService)
            },
            onDismissDialogCreateService = {
                viewModel.onEvent(ListServiceUiEvents.OnDismissDialogCreateService)
            }
        )
    }
}

fun NavHostController.navigateToServicesScreen(
    navOptions: NavOptions? = null
) {
    navigate(DrawerHomeAdminDestinations.Services.route, navOptions)
}