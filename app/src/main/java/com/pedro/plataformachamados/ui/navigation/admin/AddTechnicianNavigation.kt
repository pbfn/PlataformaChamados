package com.pedro.plataformachamados.ui.navigation.admin

import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pedro.technicians.events.ProfileUiEvents
import com.pedro.technicians.model.TechnicianUI
import com.pedro.technicians.screens.ProfileScreen
import com.pedro.technicians.viewmodel.ProfileScreenViewModel
import org.koin.androidx.compose.koinViewModel

const val addTechnicianRoute: String = "addTechnicianRoute"

fun NavGraphBuilder.addTechnicianScreen(
    onPopBackStack: () -> Unit,
) {
    composable(
        route = "$addTechnicianRoute?isEditing={isEditing}&technicianId={technicianId}",
        arguments = listOf(
            navArgument("isEditing") { type = NavType.BoolType; defaultValue = false },
            navArgument("technicianId") { type = NavType.IntType; nullable = false }
        )
    ) { backStackEntry ->
        val isEditing = backStackEntry.arguments?.getBoolean("isEditing") ?: false
        val technicianId = backStackEntry.arguments?.getInt("technicianId") ?: 0


        val viewModel = koinViewModel<ProfileScreenViewModel>()
        val state by viewModel.state.collectAsState()

        val context = LocalContext.current

        LaunchedEffect(Unit) {
            viewModel.onEvent(ProfileUiEvents.OnSetInitialScreen(isEditing, technicianId.toInt()))
        }

        LaunchedEffect(Unit) {
            viewModel.eventFlow.collect { event ->
                when (event) {
                    ProfileUiEvents.TechnicianSaved -> {
                        onPopBackStack()
                        Toast.makeText(context, "Técnico salvo com sucesso", Toast.LENGTH_SHORT).show()
                    }
                    else -> {}
                }
            }
        }

        ProfileScreen(
            state = state,
            onNavigateBack = onPopBackStack,
            onNameChanged = {
                viewModel.onEvent(ProfileUiEvents.OnChangeName(it))
            },
            onEmailChanged = {
                viewModel.onEvent(ProfileUiEvents.OnChangeEmail(it))
            },
            onPasswordChanged = {
                viewModel.onEvent(ProfileUiEvents.OnChangePassword(it))
            },
            onSave = {
                viewModel.onEvent(ProfileUiEvents.OnSaveTechnician)
            }
        )
    }
}

fun NavHostController.navigateToAddTechnicianScreen(
    navOptions: NavOptions? = null,
    isEditing: Boolean,
    technicianSelected: TechnicianUI?
) {
    val technicianId = technicianSelected?.id ?: 0
    navigate(buildAddTechnicianRoute(isEditing, technicianId), navOptions)
}

private fun buildAddTechnicianRoute(isEditing: Boolean, technicianId: Int): String {
    return "addTechnicianRoute?isEditing=$isEditing&technicianId=${technicianId}"
}