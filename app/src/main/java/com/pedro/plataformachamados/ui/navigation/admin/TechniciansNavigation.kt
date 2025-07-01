package com.pedro.plataformachamados.ui.navigation.admin

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pedro.technicians.model.TechnicianUI
import com.pedro.technicians.screens.ListTechniciansScreen
import com.pedro.technicians.viewmodel.ListTechniciansViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.technicianScreen(
    onNavigateToAddTechnician: () -> Unit,
    onNavigateToEditTechnician: (TechnicianUI) -> Unit
) {
    composable(DrawerHomeAdminDestinations.Technicians.route) {
        val viewModel = koinViewModel<ListTechniciansViewModel>()
        val state by viewModel.state.collectAsState()
        ListTechniciansScreen(
            onClickAddTechnician = onNavigateToAddTechnician,
            onClickEditTechnician = { technician ->
                onNavigateToEditTechnician(technician)
            },
            state = state,
        )
    }
}

fun NavHostController.navigateToTechnicianScreen(
    navOptions: NavOptions? = null
) {
    navigate(DrawerHomeAdminDestinations.Technicians.route, navOptions)
}