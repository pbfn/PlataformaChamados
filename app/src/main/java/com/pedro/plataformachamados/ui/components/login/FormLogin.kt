package com.pedro.plataformachamados.ui.components.login

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.plataformachamados.ui.components.buttons.CustomButton
import com.pedro.plataformachamados.ui.components.buttons.SizeCustomButton
import com.pedro.plataformachamados.ui.components.buttons.TypeCustomButton
import com.pedro.plataformachamados.ui.components.texfields.CustomTextField
import com.pedro.plataformachamados.ui.theme.Gray200
import com.pedro.plataformachamados.ui.theme.Gray300
import com.pedro.plataformachamados.ui.theme.Gray500
import com.pedro.plataformachamados.ui.theme.TypographyPersonalizada

@Composable
fun FormLogin(
    modifier: Modifier = Modifier,
    email: String,
    onEmailChanged: (String) -> Unit,
    helperTextEmail: String,
    emailHasError: Boolean,
    password: String,
    onPasswordChanged: (String) -> Unit,
    helperTextPassword: String,
    passwordHasError: Boolean,
    onClickLogin: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()

            .clip(RoundedCornerShape(10.dp))
            .border(width = 1.dp, color = Gray500, shape = RoundedCornerShape(10.dp))
    ) {

        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Acesse o portal",
                    style = TypographyPersonalizada.textLg,
                    color = Gray200
                )
                Text(
                    "Entre usando seu e-mail e senha cadastrados",
                    style = TypographyPersonalizada.textXs,
                    color = Gray300
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CustomTextField(
                    onTextChanged = {
                        onEmailChanged(it)
                    },
                    helperText = helperTextEmail,
                    placeholder = "exemplo@mail.com",
                    text = email,
                    label = "E-MAIL",
                    isError = emailHasError
                )

                CustomTextField(
                    onTextChanged = {
                        onPasswordChanged(it)
                    },
                    helperText = helperTextPassword,
                    placeholder = "Digite sua senha",
                    text = password,
                    label = "Senha",
                    isError = passwordHasError
                )
            }

            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onClickLogin,
                sizeCustomButton = SizeCustomButton.Large,
                text = "Entrar",
                typeCustomButton = TypeCustomButton.Primary
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun FormLoginPrev() {
    FormLogin(
        email = "",
        password = "",
        emailHasError = false,
        passwordHasError = false,
        helperTextEmail = "",
        helperTextPassword = "",
        onEmailChanged = {},
        onPasswordChanged = {},
        onClickLogin = {}
    )
}