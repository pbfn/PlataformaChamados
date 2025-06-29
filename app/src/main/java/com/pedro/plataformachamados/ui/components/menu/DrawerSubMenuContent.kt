package com.pedro.plataformachamados.ui.components.menu

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
import com.pedro.design_system.ui.theme.BlueDark
import com.pedro.design_system.ui.theme.FeedbackDanger
import com.pedro.design_system.ui.theme.Gray100
import com.pedro.design_system.ui.theme.Gray400
import com.pedro.design_system.ui.theme.Gray600
import com.pedro.design_system.ui.theme.CustomTypography

@Composable
fun DrawerSubMenuContent(
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

        Text(text = title.uppercase(), style = CustomTypography.textXxs, color = Gray400)

        Column {
            listItemsMenu.forEach { item ->

                var isSelected = item.type != TypeItemMenuDrawer.Logout  && item.type == selectedItem

                val color = if(item.type == TypeItemMenuDrawer.Logout ) FeedbackDanger else Gray400

                NavigationDrawerItem(
                    modifier = Modifier.height(40.dp),
                    label = { Text(text = item.title, style = CustomTypography.textSm) },
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
                        unselectedIconColor = color,
                        selectedTextColor = Gray600,
                        unselectedTextColor = color,
                    ),
                )
            }
        }


    }
}

@Preview
@Composable
private fun DrawerSubMenuContentPreview() {
    DrawerSubMenuContent(
        title = "Menu",
        listItemsMenu = listOf(
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
        ),
        selectedItem = TypeItemMenuDrawer.Logout,
        onSelectedItem = {}
    )
}