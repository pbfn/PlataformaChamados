package com.pedro.plataformachamados.ui.screens.admin.home

import androidx.annotation.DrawableRes
import com.pedro.plataformachamados.R
import com.pedro.plataformachamados.ui.components.menu.ItemMenuDrawer
import com.pedro.plataformachamados.ui.components.menu.TypeItemMenuDrawer

data class HomeUiState(
    val selectedItemMenuDrawer: TypeItemMenuDrawer = TypeItemMenuDrawer.Ticket,
    val itemsMenuDrawer: List<ItemMenuDrawer> = emptyList(),
    val itemsSubMenuDrawer: List<ItemMenuDrawer> = emptyList(),
    @DrawableRes val iconTopAppBar: Int = R.drawable.menu,
)
