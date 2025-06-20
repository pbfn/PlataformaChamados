package com.pedro.plataformachamados.ui.screens.admin.home

import com.pedro.plataformachamados.ui.components.menu.TypeItemMenuDrawer

sealed class HomeUiEvent {
    object OnLoadItemsMenu : HomeUiEvent()

    data class OnSelectedItemMenu(val newItem: TypeItemMenuDrawer) : HomeUiEvent()

    data class OnChangeIconTopAppBar(val isOpen: Boolean) : HomeUiEvent()
}