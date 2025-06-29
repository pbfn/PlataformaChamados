package com.pedro.plataformachamados.ui.navigation.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pedro.plataformachamados.ui.screens.admin.technicians.profile.ProfileTechniciansScreen

const val addTechnicianRoute: String = "addTechnicianRoute"

fun NavGraphBuilder.addTechnicianScreen(
    onPopBackStack: () -> Unit
){
    composable(addTechnicianRoute) {
        val listMorningHours = listOf<String>("07:00", "08:00", "09:00", "10:00", "11:00", "12:00")
        val listMorningSelected = listOf<String>("07:00", "08:00", "11:00", "12:00")

        val listAfternoonHours = listOf<String>("13:00", "14:00", "15:00", "16:00", "17:00", "18:00")
        val listAfternoonSelected = listOf<String>("14:00", "15:00")

        val listNightHours = listOf<String>("19:00", "20:00", "21:00", "22:00", "23:00")
        val listNightSelected = listOf<String>("23:00")
        ProfileTechniciansScreen(
            isEdit = true,
            onNavigateBack = onPopBackStack,
            name = "Pedro Bruno Fernandes",
            onNameChanged = { },
            helperTextName = "",
            nameHasError = false,
            email = "pedro.bruno@test.com",
            onEmailChanged = {},
            helperTextEmail = "",
            emailHasError = false,
            password = "",
            onPasswordChanged = {},
            helperTextPassword = "Mínimo de 6 dígitos",
            passwordHasError = false,
            listMorningHours = listMorningHours,
            listMorningSelected = listMorningSelected,
            listAfternoonHours = listAfternoonHours,
            listAfternoonSelected = listAfternoonSelected,
            listNightHours = listNightHours,
            listNightSelected = listNightSelected,
        )
    }
}

fun NavHostController.navigateToAddTechnicianScreen(
    navOptions: NavOptions? = null
) {
    navigate(addTechnicianRoute, navOptions)
}