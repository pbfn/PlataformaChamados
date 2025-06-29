package com.pedro.design_system.ui.components.topappbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.R
import com.pedro.design_system.ui.components.buttons.CustomButton
import com.pedro.design_system.ui.components.buttons.SizeCustomButton
import com.pedro.design_system.ui.components.buttons.TypeCustomButton
import com.pedro.design_system.ui.theme.BlueDark
import com.pedro.design_system.ui.theme.BlueLight
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.design_system.ui.theme.Gray100
import com.pedro.design_system.ui.theme.Gray600

@Composable
fun TopAppBarCustom(
    modifier: Modifier = Modifier,
    @DrawableRes iconButton: Int,
    typeUser: String,
    nameUser: String,
    onClickButton: () -> Unit
) {

    Row(
        modifier
            .fillMaxWidth()
            .height(92.dp)
            .background(Gray100)
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CustomButton(
                onClick = {
                    onClickButton()
                },
                iconRes = iconButton,
                sizeCustomButton = SizeCustomButton.Large,
                typeCustomButton = TypeCustomButton.Primary,
            )
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Image(
                    modifier = Modifier.size(44.dp),
                    painter = painterResource(R.drawable.logo_icondark),
                    contentDescription = "logo_icondark"
                )
                Column {
                    Text(text = "HelpDesk", style = CustomTypography.textLg, color = Gray600)
                    Text(
                        text = typeUser.uppercase(),
                        style = CustomTypography.textXxs,
                        color = BlueLight
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .background(color = BlueDark, shape = RoundedCornerShape(50))
                .size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(nameUser, style = CustomTypography.textSm, color = Gray600)
        }
    }
}


@Preview
@Composable
private fun TopAppBarCustomPreview() {
    TopAppBarCustom(
        iconButton = R.drawable.menu,
        typeUser = "Admin",
        nameUser = "PB",
        onClickButton = {}
    )
}


@Preview
@Composable
private fun TopAppBarCustomPreview1() {
    TopAppBarCustom(
        iconButton = R.drawable.x,
        typeUser = "Admin",
        nameUser = "PB",
        onClickButton = {}
    )
}