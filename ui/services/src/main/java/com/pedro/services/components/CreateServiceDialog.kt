package com.pedro.services.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.pedro.design_system.R
import com.pedro.design_system.ui.components.buttons.CustomButton
import com.pedro.design_system.ui.components.buttons.SizeCustomButton
import com.pedro.design_system.ui.components.buttons.TypeCustomButton
import com.pedro.design_system.ui.components.texfields.CustomTextField
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.design_system.ui.theme.Gray200
import com.pedro.design_system.ui.theme.Gray300
import com.pedro.design_system.ui.theme.Gray500
import com.pedro.design_system.ui.theme.Gray600

@Composable
fun CreateServiceDialog(
    onDismiss: () -> Unit,
    onSave: () -> Unit,
    serviceName: String,
    serviceValue: String,
    onChangeServiceName: (String) -> Unit,
    onChangeServiceValue: (String) -> Unit,
) {

    val focusManager = LocalFocusManager.current

    Dialog(
        onDismissRequest = {
            onDismiss()
        }) {
        Column(modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = Gray600)) {
            Row(
                modifier = Modifier.padding(horizontal = 28.dp, vertical = 21.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Cadastro de serviço",
                    style = CustomTypography.headingMd.copy(
                        fontWeight = FontWeight.Bold,
                        color = Gray200
                    ),
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = {
                        onDismiss()
                    },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.x),
                        contentDescription = "close icon",
                        tint = Gray300,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            HorizontalDivider(color = Gray500)

            Column(Modifier.padding(top = 28.dp, bottom = 32.dp, start = 28.dp, end = 28.dp)) {
                CustomTextField(
                    text = serviceName,
                    placeholder = "Nome do serviço",
                    label = "TÍTULO",
                    helperText = "",
                    isError = false,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    onTextChanged = {
                        onChangeServiceName(it)
                    }
                )

                CustomTextField(
                    text = serviceValue,
                    placeholder = "0,00",
                    label = "VALOR",
                    helperText = "",
                    isError = false,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    onTextChanged = {
                        onChangeServiceValue(it)
                    }
                )
            }

            HorizontalDivider(color = Gray500)

            Row(Modifier.padding(top = 24.dp, bottom = 24.dp, start = 28.dp, end = 28.dp)) {
                CustomButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Salvar",
                    onClick = { onSave() },
                    sizeCustomButton = SizeCustomButton.Large,
                    typeCustomButton = TypeCustomButton.Primary,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CreateServiceDialogPreview() {
    CreateServiceDialog(
        onDismiss = {},
        onSave = {},
        onChangeServiceName = {},
        onChangeServiceValue = {},
        serviceName = "",
        serviceValue = ""
    )
}