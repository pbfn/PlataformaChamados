package com.pedro.login.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.ui.components.buttons.CustomButton
import com.pedro.design_system.ui.components.buttons.SizeCustomButton
import com.pedro.design_system.ui.components.buttons.TypeCustomButton
import com.pedro.design_system.ui.components.texfields.CustomTextField
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.design_system.ui.theme.Gray200
import com.pedro.design_system.ui.theme.Gray300
import com.pedro.design_system.ui.theme.Gray500

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

    val focusManager = LocalFocusManager.current

    Box(
        modifier = modifier
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
                    style = CustomTypography.textLg,
                    color = Gray200
                )
                Text(
                    "Entre usando seu e-mail e senha cadastrados",
                    style = CustomTypography.textXs,
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
                    isError = emailHasError,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                )

                CustomTextField(
                    onTextChanged = {
                        onPasswordChanged(it)
                    },
                    helperText = helperTextPassword,
                    placeholder = "Digite sua senha",
                    text = password,
                    label = "Senha",
                    isError = passwordHasError,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                            onClickLogin()
                        }
                    ),
                )
            }

            CustomButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    focusManager.clearFocus()
                    onClickLogin()
                },
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