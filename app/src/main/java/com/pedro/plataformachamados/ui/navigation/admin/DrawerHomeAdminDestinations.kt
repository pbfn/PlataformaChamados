package com.pedro.plataformachamados.ui.navigation.admin

sealed class DrawerHomeAdminDestinations(val route: String) {
    object Ticket : DrawerHomeAdminDestinations("ticket_route")
    object Technicians : DrawerHomeAdminDestinations("technicians_route")
    object Services : DrawerHomeAdminDestinations("services_route")
}