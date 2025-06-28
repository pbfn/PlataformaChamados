package com.pedro.plataformachamados.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pedro.plataformachamados.ui.screens.splash.SplashScreen

const val splashScreenRoute: String = "splash"

fun NavGraphBuilder.splashScreen() {
    composable(splashScreenRoute) {
        SplashScreen()
    }
}