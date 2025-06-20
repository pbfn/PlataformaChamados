package com.pedro.plataformachamados.ui.components.menu

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.plataformachamados.R
import com.pedro.plataformachamados.ui.theme.BlueDark
import com.pedro.plataformachamados.ui.theme.Gray100
import com.pedro.plataformachamados.ui.theme.Gray400
import com.pedro.plataformachamados.ui.theme.Gray600
import com.pedro.plataformachamados.ui.theme.TypographyPersonalizada

@Composable
fun DrawerMenuContent(
    modifier: Modifier = Modifier,
    title: String,
    listItemsMenu: List<ItemMenuDrawer>,
    selectedItem: TypeItemMenuDrawer,
    onSelectedItem: (TypeItemMenuDrawer) -> Unit
) {
    Column(
        modifier.padding(horizontal = 20.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(text = title.uppercase(), style = TypographyPersonalizada.textXxs, color = Gray400)
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            listItemsMenu.forEach { item ->

                val isSelected = item.type == selectedItem

                NavigationDrawerItem(
                    modifier = Modifier.height(44.dp),
                    label = { Text(text = item.title, style = TypographyPersonalizada.textSm) },
                    selected = isSelected,
                    shape = RoundedCornerShape(5.dp),
                    onClick = { onSelectedItem(item.type) },
                    icon = {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = "icon_item_menu",
                            modifier = Modifier.size(20.dp),
                        )
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = BlueDark,
                        unselectedContainerColor = Gray100,
                        selectedIconColor = Gray600,
                        unselectedIconColor = Gray400,
                        selectedTextColor = Gray600,
                        unselectedTextColor = Gray400,
                    ),
                )
            }
        }

    }

}

data class ItemMenuDrawer(
    val type: TypeItemMenuDrawer,
    val title: String,
    @DrawableRes val icon: Int,
)

enum class TypeItemMenuDrawer {
    Ticket,
    Technician,
    Admin,
    Service,
    Profile,
    Logout
}

@Preview
@Composable
private fun DrawerMenuContentPrev() {
    DrawerMenuContent(
        title = "Menu",
        listItemsMenu = listOf(
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
        ),
        selectedItem = TypeItemMenuDrawer.Ticket,
        onSelectedItem = {}
    )
}