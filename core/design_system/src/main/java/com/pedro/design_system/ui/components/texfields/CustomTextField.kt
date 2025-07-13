package com.pedro.design_system.ui.components.texfields

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.R
import com.pedro.design_system.ui.components.util.rememberSkeletonBrush
import com.pedro.design_system.ui.theme.BlueBase
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.design_system.ui.theme.FeedbackDanger
import com.pedro.design_system.ui.theme.Gray100
import com.pedro.design_system.ui.theme.Gray200
import com.pedro.design_system.ui.theme.Gray300
import com.pedro.design_system.ui.theme.Gray400
import com.pedro.design_system.ui.theme.Gray500

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String,
    label: String,
    helperText: String,
    isError: Boolean,
    isMoney: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
    keyboardActions: KeyboardActions,
    onTextChanged: (String) -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState()

    val primaryColor = when {
        isError -> FeedbackDanger
        isFocused.value -> BlueBase
        else -> Gray300
    }

    val dividerColor = when {
        isFocused.value -> BlueBase
        else -> Gray500
    }

    Column(modifier) {
        Text(text = label, style = CustomTypography.textXxs, color = primaryColor)
        BasicTextField(
            interactionSource = interactionSource,
            value = text,
            onValueChange = { newText ->
                onTextChanged(newText)
            },
            decorationBox = { innerTextField ->
                Column(modifier = Modifier.height(40.dp)) {
                    Row(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    ) {
                        if (isMoney)
                            Text(
                                "R$",
                                style = CustomTypography.headingMd.copy(color = Gray100),
                                modifier = Modifier.padding(end = 8.dp)
                            )

                        if (text.isNotEmpty())
                            innerTextField()
                        else
                            Text(
                                text = placeholder,
                                style = CustomTypography.headingMd,
                                color = Gray400
                            )
                    }
                    HorizontalDivider(color = dividerColor)
                }
            },
            cursorBrush = SolidColor(primaryColor),
            textStyle = CustomTypography.headingMd.copy(color = Gray200),
            visualTransformation = visualTransformation,
            keyboardOptions = if (isMoney) keyboardOptions.copy(keyboardType = KeyboardType.Number) else keyboardOptions,
            keyboardActions = keyboardActions,
        )

        AnimatedVisibility(helperText.isNotEmpty()) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                if (isError) {
                    Icon(
                        painter = painterResource(R.drawable.circle_alert),
                        contentDescription = "icon_alert",
                        tint = FeedbackDanger,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = helperText,
                        style = CustomTypography.textXs.copy(fontWeight = FontWeight.Light),
                        color = primaryColor
                    )
                } else {
                    Text(
                        text = helperText,
                        style = CustomTypography.textXs.copy(fontWeight = FontWeight.Light),
                        color = Gray400
                    )
                }

            }
        }
    }

}


@Composable
fun CustomTextFieldSkeleton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(brush = rememberSkeletonBrush(), shape = RoundedCornerShape(5.dp))
            .height(50.dp)
    ) {
    }
}

@Preview
@Composable
private fun CustomTextFieldPrev1() {
    CustomTextField(
        isError = false,
        text = "",
        label = "Label",
        placeholder = "Placeholder",
        helperText = "Helper text",
        onTextChanged = {},
        keyboardActions = KeyboardActions()
    )
}

@Preview
@Composable
private fun CustomTextFieldPrev2() {
    CustomTextField(
        isError = false,
        text = "Text",
        label = "Label",
        placeholder = "Placeholder",
        helperText = "Helper text",
        onTextChanged = {},
        keyboardActions = KeyboardActions()
    )
}

@Preview
@Composable
private fun CustomTextFieldPrev3() {
    CustomTextField(
        isError = true,
        text = "",
        label = "Label",
        placeholder = "Placeholder",
        helperText = "Helper text",
        onTextChanged = {},
        keyboardActions = KeyboardActions()
    )
}

@Preview
@Composable
private fun CustomTextFieldPrev4() {
    CustomTextField(
        isError = false,
        isMoney = true,
        text = "",
        label = "Label",
        placeholder = "Placeholder",
        helperText = "Helper text",
        onTextChanged = {},
        keyboardActions = KeyboardActions()
    )
}

@Preview
@Composable
private fun CustomTextFieldSkeletonPrev() {
    CustomTextFieldSkeleton()
}