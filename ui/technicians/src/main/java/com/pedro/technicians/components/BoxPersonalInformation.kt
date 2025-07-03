package com.pedro.technicians.components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pedro.design_system.ui.components.CustomBoxWithBorder
import com.pedro.design_system.ui.components.texfields.CustomTextField
import com.pedro.design_system.ui.components.texfields.CustomTextFieldSkeleton
import com.pedro.design_system.ui.components.util.rememberSkeletonBrush
import com.pedro.design_system.ui.theme.BlueDark
import com.pedro.design_system.ui.theme.Gray200
import com.pedro.design_system.ui.theme.Gray300
import com.pedro.design_system.ui.theme.Gray600
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.design_system.ui.utils.getTwoInitialsAlways
import com.pedro.technicians.states.profile.BoxPersonalDataUiState

@Composable
fun BoxPersonalInformation(
    state: BoxPersonalDataUiState,
    onNameChanged: (String) -> Unit,
    focusManager: FocusManager,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
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
            if (state.isEdit) {
                Box(
                    modifier = Modifier
                        .background(color = BlueDark, shape = RoundedCornerShape(50))
                        .size(48.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        getTwoInitialsAlways(state.name),
                        style = CustomTypography.textSm.copy(fontSize = 21.sp),
                        color = Gray600
                    )
                }
            }
            CustomTextField(
                onTextChanged = {
                    onNameChanged(it)
                },
                helperText = state.helperTextName,
                placeholder = "Digite o nome completo",
                text = state.name,
                label = "NOME",
                isError = state.nameHasError,
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
                helperText = state.helperTextEmail,
                placeholder = "exemplo@mail.com",
                text = state.email,
                label = "E-MAIL",
                isError = state.emailHasError,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
            )

            if (!state.isEdit) {
                CustomTextField(
                    onTextChanged = {
                        onPasswordChanged(it)
                    },
                    helperText = state.helperTextPassword,
                    placeholder = "Defina a senha de acesso",
                    text = state.password,
                    label = "Senha",
                    isError = state.passwordHasError,
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

@Composable
fun BoxPersonalInformationSkeleton() {
    CustomBoxWithBorder {
        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                modifier = Modifier.background(brush = rememberSkeletonBrush(),RoundedCornerShape(5.dp)),
                text = "Dados pessoais",
                style = CustomTypography.textLg,
                color = Color.Transparent
            )
            Text(
                modifier = Modifier.background(brush = rememberSkeletonBrush(),RoundedCornerShape(5.dp)),
                text = "Defina as informações do perfil técnico",
                style = CustomTypography.textXs,
                color = Color.Transparent
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CustomTextFieldSkeleton()
            CustomTextFieldSkeleton()
            CustomTextFieldSkeleton()
            CustomTextFieldSkeleton()
        }
    }
}

@Preview
@Composable
private fun BoxPersonalInformationPreview() {
    BoxPersonalInformation(
        state = BoxPersonalDataUiState(),
        onNameChanged = {},
        focusManager = LocalFocusManager.current,
        onEmailChanged = {},
        onPasswordChanged = {}
    )
}

@Preview
@Composable
private fun BoxPersonalInformationSkeletonPreview() {
    BoxPersonalInformationSkeleton()
}