package com.pedro.plataformachamados.ui.components.register

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.plataformachamados.ui.components.buttons.CustomButton
import com.pedro.plataformachamados.ui.components.buttons.SizeCustomButton
import com.pedro.plataformachamados.ui.components.buttons.TypeCustomButton
import com.pedro.plataformachamados.ui.theme.Gray200
import com.pedro.plataformachamados.ui.theme.Gray300
import com.pedro.plataformachamados.ui.theme.Gray500
import com.pedro.plataformachamados.ui.theme.TypographyPersonalizada

@Composable
fun BoxGoToLogin(
    modifier: Modifier = Modifier,
    onGoToLogin: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()

            .clip(RoundedCornerShape(10.dp))
            .border(width = 1.dp, color = Gray500, shape = RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Já tem uma conta?",
                    style = TypographyPersonalizada.headingMd.copy(fontWeight = FontWeight.Bold),
                    color = Gray200
                )
                Text(
                    "Entre agora mesmo",
                    style = TypographyPersonalizada.textXs,
                    color = Gray300
                )
            }

            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onGoToLogin,
                sizeCustomButton = SizeCustomButton.Large,
                text = "Acessar conta",
                typeCustomButton = TypeCustomButton.Secondary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BoxGoToLoginPrev() {
    BoxGoToLogin(onGoToLogin = {})
}