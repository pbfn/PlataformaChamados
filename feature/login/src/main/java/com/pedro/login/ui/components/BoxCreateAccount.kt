package com.pedro.login.ui.components

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
import com.pedro.design_system.ui.components.buttons.CustomButton
import com.pedro.design_system.ui.components.buttons.SizeCustomButton
import com.pedro.design_system.ui.components.buttons.TypeCustomButton
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.design_system.ui.theme.Gray200
import com.pedro.design_system.ui.theme.Gray300
import com.pedro.design_system.ui.theme.Gray500

@Composable
fun BoxCreateAccount(
    onGoToCreateAccount: () -> Unit
) {
    Box(
        modifier = Modifier
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
                    "Ainda não tem uma conta",
                    style = CustomTypography.headingMd.copy(fontWeight = FontWeight.Bold),
                    color = Gray200
                )
                Text(
                    "Cadastre agora mesmo",
                    style = CustomTypography.textXs,
                    color = Gray300
                )
            }

            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onGoToCreateAccount,
                sizeCustomButton = SizeCustomButton.Large,
                text = "Criar conta",
                typeCustomButton = TypeCustomButton.Secondary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BoxCreateAccountPrev() {
    BoxCreateAccount(
        onGoToCreateAccount = {}
    )
}