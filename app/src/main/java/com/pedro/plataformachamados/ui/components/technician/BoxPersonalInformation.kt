package com.pedro.plataformachamados.ui.components.technician

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pedro.design_system.ui.components.CustomBoxWithBorder
import com.pedro.design_system.ui.components.texfields.CustomTextField
import com.pedro.design_system.ui.theme.BlueDark
import com.pedro.design_system.ui.theme.Gray200
import com.pedro.design_system.ui.theme.Gray300
import com.pedro.design_system.ui.theme.Gray600
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.design_system.ui.utils.getTwoInitialsAlways

@Composable
fun BoxPersonalInformation(
    isEdit: Boolean,
    name: String,
    onNameChanged: (String) -> Unit,
    helperTextName: String,
    nameHasError: Boolean,
    focusManager: FocusManager,
    onEmailChanged: (String) -> Unit,
    helperTextEmail: String,
    email: String,
    emailHasError: Boolean,
    onPasswordChanged: (String) -> Unit,
    helperTextPassword: String,
    password: String,
    passwordHasError: Boolean
) {
    CustomBoxWithBorder {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Dados pessoais",
                style = CustomTypography.textLg,
                color = Gray200
            )
            Text(
                text = "Defina as informações do perfil técnico",
                style = CustomTypography.textXs,
                color = Gray300
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (isEdit) {
                Box(
                    modifier = Modifier
                        .background(color = BlueDark, shape = RoundedCornerShape(50))
                        .size(48.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        getTwoInitialsAlways(name),
                        style = CustomTypography.textSm.copy(fontSize = 21.sp),
                        color = Gray600
                    )
                }
            }
            CustomTextField(
                onTextChanged = {
                    onNameChanged(it)
                },
                helperText = helperTextName,
                placeholder = "Digite o nome completo",
                text = name,
                label = "NOME",
                isError = nameHasError,
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

            if (!isEdit) {
                CustomTextField(
                    onTextChanged = {
                        onPasswordChanged(it)
                    },
                    helperText = helperTextPassword,
                    placeholder = "Defina a senha de acesso",
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

                        }
                    ),
                )
            }
        }
    }
}