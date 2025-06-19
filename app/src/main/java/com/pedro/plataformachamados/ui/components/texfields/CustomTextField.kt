package com.pedro.plataformachamados.ui.components.texfields

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.plataformachamados.R
import com.pedro.plataformachamados.ui.theme.BlueBase
import com.pedro.plataformachamados.ui.theme.FeedbackDanger
import com.pedro.plataformachamados.ui.theme.Gray200
import com.pedro.plataformachamados.ui.theme.Gray300
import com.pedro.plataformachamados.ui.theme.Gray400
import com.pedro.plataformachamados.ui.theme.TypographyPersonalizada

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String,
    label: String,
    helperText: String,
    isError: Boolean,
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
        else -> Gray400
    }

    Column(modifier) {
        Text(text = label, style = TypographyPersonalizada.textXxs, color = primaryColor)
        BasicTextField(
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
                        if (text.isNotEmpty())
                            innerTextField()
                        else
                            Text(
                                text = placeholder,
                                style = TypographyPersonalizada.headingMd,
                                color = Gray400
                            )
                    }
                    HorizontalDivider(color = dividerColor)
                }
            },
            cursorBrush = SolidColor(primaryColor),
            textStyle = TypographyPersonalizada.headingMd.copy(color = Gray200)
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
                        style = TypographyPersonalizada.textXs.copy(fontWeight = FontWeight.Light),
                        color = primaryColor
                    )
                } else {
                    Text(
                        text = helperText,
                        style = TypographyPersonalizada.textXs.copy(fontWeight = FontWeight.Light),
                        color = Gray400
                    )
                }

            }
        }
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
        onTextChanged = {}
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
        onTextChanged = {}
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
        onTextChanged = {})
}