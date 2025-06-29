package com.pedro.plataformachamados.ui.screens.admin.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.pedro.plataformachamados.R
import com.pedro.plataformachamados.ui.components.menu.DrawerMenuContent
import com.pedro.plataformachamados.ui.components.menu.DrawerSubMenuContent
import com.pedro.plataformachamados.ui.components.menu.ItemMenuDrawer
import com.pedro.plataformachamados.ui.components.menu.TypeItemMenuDrawer
import com.pedro.plataformachamados.ui.components.topappbar.TopAppBarCustom
import com.pedro.plataformachamados.ui.navigation.admin.addTechnicianScreen
import com.pedro.plataformachamados.ui.navigation.admin.drawerHomeAdmGraph
import com.pedro.plataformachamados.ui.navigation.admin.drawerHomeAdmGraphRoute
import com.pedro.plataformachamados.ui.navigation.admin.navigateToAddTechnicianScreen
import com.pedro.plataformachamados.ui.navigation.admin.navigateToServicesScreen
import com.pedro.plataformachamados.ui.navigation.admin.navigateToTechnicianScreen
import com.pedro.plataformachamados.ui.navigation.admin.navigateToTicketsScreen
import com.pedro.plataformachamados.ui.theme.Gray100
import com.pedro.plataformachamados.ui.theme.Gray200
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit
) {

    LaunchedEffect(Unit) {
        onEvent(HomeUiEvent.OnLoadItemsMenu)
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    val navController = rememberNavController()

    Column(modifier) {
        TopAppBarCustom(
            iconButton = state.iconTopAppBar,
            typeUser = "Admin",
            nameUser = "PB",
            onClickButton = {
                scope.launch {
                    drawerState.apply {
                        if (isClosed) open() else close()
                        onEvent(HomeUiEvent.OnChangeIconTopAppBar(isOpen))
                    }
                }
            })

        ModalNavigationDrawer(
            drawerState = drawerState,
            gesturesEnabled = false,
            drawerContent = {
                ModalDrawerSheet(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    drawerShape = RoundedCornerShape(0.dp),
                    drawerContainerColor = Gray100
                ) {
                    DrawerMenuContent(
                        title = "Menu",
                        listItemsMenu = state.itemsMenuDrawer,
                        selectedItem = state.selectedItemMenuDrawer,
                        onSelectedItem = { newItem ->
                            onEvent(HomeUiEvent.OnSelectedItemMenu(newItem))
                            scope.launch {
                                drawerState.apply {
                                    close()
                                    onEvent(HomeUiEvent.OnChangeIconTopAppBar(isOpen))
                                }
                            }

                            when (newItem) {
                                TypeItemMenuDrawer.Ticket -> navController.navigateToTicketsScreen(
                                    navOptions =
                                        navOptions {
                                            launchSingleTop = true
                                            popUpTo(drawerHomeAdmGraphRoute) {
                                                inclusive = false
                                            }
                                        }
                                )

                                TypeItemMenuDrawer.Technician -> navController.navigateToTechnicianScreen(
                                    navOptions =
                                        navOptions {
                                            launchSingleTop = true
                                            popUpTo(drawerHomeAdmGraphRoute) {
                                                inclusive = false
                                            }
                                        }
                                )
                                TypeItemMenuDrawer.Service -> navController.navigateToServicesScreen(
                                    navOptions =
                                        navOptions {
                                            launchSingleTop = true
                                            popUpTo(drawerHomeAdmGraphRoute) {
                                                inclusive = false
                                            }
                                        }
                                )

                                else -> navController.navigateToServicesScreen(
                                    navOptions =
                                        navOptions {
                                            launchSingleTop = true
                                            popUpTo(drawerHomeAdmGraphRoute) {
                                                inclusive = false
                                            }
                                        }
                                )
                            }
                        }
                    )

                    HorizontalDivider()

                    DrawerSubMenuContent(
                        title = "Opções",
                        listItemsMenu = state.itemsSubMenuDrawer,
                        selectedItem = state.selectedItemMenuDrawer,
                        onSelectedItem = { newItem ->
                            onEvent(HomeUiEvent.OnSelectedItemMenu(newItem))
                            scope.launch {
                                drawerState.apply {
                                    close()
                                    onEvent(HomeUiEvent.OnChangeIconTopAppBar(isOpen))
                                }
                            }
                        }
                    )
                }
            }
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(color = Gray200)
                    .background(
                        shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp),
                        color = Color.White
                    )
                    .padding(horizontal = 24.dp, vertical = 28.dp)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = drawerHomeAdmGraphRoute
                ) {

                    drawerHomeAdmGraph(
                        onNavigateToAddTechnician = {
                            navController.navigateToAddTechnicianScreen()
                        }
                    )

                    addTechnicianScreen(
                        onPopBackStack = {
                            navController.popBackStack()
                        }
                    )

                }
            }

        }
    }

}

@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen(
        state = HomeUiState(
            itemsMenuDrawer = listOf(
                ItemMenuDrawer(
                    type = TypeItemMenuDrawer.Ticket,
                    title = "Chamados",
                    icon = R.drawable.clipboard_list,
                ),
                ItemMenuDrawer(
                    type = TypeItemMenuDrawer.Technician,
                    title = "Técnicos",
                    icon = R.drawable.users,
                )
            )
        ),
        onEvent = {

        }
    )
}