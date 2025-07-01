package com.pedro.plataformachamados.ui.navigation.admin

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pedro.technicians.screens.ProfileScreen
import com.pedro.technicians.viewmodel.ProfileScreenViewModel
import org.koin.androidx.compose.koinViewModel

const val addTechnicianRoute: String = "addTechnicianRoute"

fun NavGraphBuilder.addTechnicianScreen(
    onPopBackStack: () -> Unit
){
    composable(addTechnicianRoute) {
        val viewModel = koinViewModel<ProfileScreenViewModel>()
        val state by viewModel.state.collectAsState()

        ProfileScreen(
            state = state,
            onNavigateBack = onPopBackStack,
            onNameChanged ={},
            onEmailChanged ={},
            onPasswordChanged = {}
        )
    }
}

fun NavHostController.navigateToAddTechnicianScreen(
    navOptions: NavOptions? = null
) {
    navigate(addTechnicianRoute, navOptions)
}