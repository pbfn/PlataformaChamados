package com.pedro.plataformachamados.ui.screens.admin.home

import androidx.lifecycle.ViewModel
import com.pedro.plataformachamados.R
import com.pedro.plataformachamados.ui.components.menu.ItemMenuDrawer
import com.pedro.plataformachamados.ui.components.menu.TypeItemMenuDrawer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import repositories.AuthFirebaseRepository

class HomeViewModel(
    private val firebaseRepository: AuthFirebaseRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state: StateFlow<HomeUiState> = _state.asStateFlow()

    fun onEvent(event: HomeUiEvent) {
        when (event) {
            HomeUiEvent.OnLoadItemsMenu -> loadItemsMenu()
            is HomeUiEvent.OnSelectedItemMenu -> onSelectedItemMenu(event.newItem)
            is HomeUiEvent.OnChangeIconTopAppBar -> onChangeIconTopAppBar(event.isOpen)
        }
    }

    private fun loadItemsMenu() {
        val itemsMenu = listOf(
            ItemMenuDrawer(
                type = TypeItemMenuDrawer.Ticket,
                title = "Chamados",
                icon = R.drawable.clipboard_list,
            ),
            ItemMenuDrawer(
                type = TypeItemMenuDrawer.Technician,
                title = "Técnicos",
                icon = R.drawable.users,
            ),
            ItemMenuDrawer(
                type = TypeItemMenuDrawer.Service,
                title = "Serviços",
                icon = R.drawable.wrench,
            )
        )

        val itemsSubMenu = listOf(
            ItemMenuDrawer(
                type = TypeItemMenuDrawer.Profile,
                title = "Perfil",
                icon = R.drawable.circle_user,
            ),
            ItemMenuDrawer(
                type = TypeItemMenuDrawer.Logout,
                title = "Sair",
                icon = R.drawable.log,
            )
        )

        _state.update { currentState ->
            currentState.copy(
                itemsMenuDrawer = itemsMenu,
                selectedItemMenuDrawer = itemsMenu.first().type,
                itemsSubMenuDrawer = itemsSubMenu
            )
        }
    }

    private fun onSelectedItemMenu(newItem: TypeItemMenuDrawer) {
        // TODO, ALTERAR TELA NO COMPOSE.
        _state.update { currentState ->
            currentState.copy(
                selectedItemMenuDrawer = newItem
            )
        }

        when (newItem) {
            TypeItemMenuDrawer.Logout -> onLogout()
            else -> null
        }
    }

    private fun onChangeIconTopAppBar(isOpen: Boolean) {
        _state.update { currentState ->
            currentState.copy(
                iconTopAppBar = if (isOpen) R.drawable.x else R.drawable.menu,
            )
        }
    }

    private fun onLogout() {
        firebaseRepository.logout()
    }

}