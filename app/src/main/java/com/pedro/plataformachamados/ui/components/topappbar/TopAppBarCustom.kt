package com.pedro.plataformachamados.ui.components.topappbar

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
import com.pedro.plataformachamados.R
import com.pedro.plataformachamados.ui.components.buttons.CustomButton
import com.pedro.plataformachamados.ui.components.buttons.SizeCustomButton
import com.pedro.plataformachamados.ui.components.buttons.TypeCustomButton
import com.pedro.plataformachamados.ui.theme.BlueDark
import com.pedro.plataformachamados.ui.theme.BlueLight
import com.pedro.plataformachamados.ui.theme.Gray100
import com.pedro.plataformachamados.ui.theme.Gray600
import com.pedro.plataformachamados.ui.theme.TypographyPersonalizada

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
                    Text(text = "HelpDesk", style = TypographyPersonalizada.textLg, color = Gray600)
                    Text(
                        text = typeUser.uppercase(),
                        style = TypographyPersonalizada.textXxs,
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
            Text(nameUser, style = TypographyPersonalizada.textSm, color = Gray600)
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