package com.pedro.plataformachamados.ui.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pedro.plataformachamados.ui.screens.admin.home.HomeScreen
import com.pedro.plataformachamados.ui.screens.admin.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

const val homeAdmRoute: String = "homeAdm"

fun NavGraphBuilder.homeAdmScreen() {
    composable(homeAdmRoute) {
        val viewModel = koinViewModel<HomeViewModel>()
        val state by viewModel.state.collectAsState()
        HomeScreen(
            state = state,
            onEvent = viewModel::onEvent
        )
    }
}

fun NavHostController.navigateToHomeAdm(
    navOptions: NavOptions? = null
) {
    navigate(homeAdmRoute, navOptions)
}