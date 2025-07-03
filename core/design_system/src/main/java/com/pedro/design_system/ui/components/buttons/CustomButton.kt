package com.pedro.design_system.ui.components.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.R
import com.pedro.design_system.ui.components.util.rememberSkeletonBrush
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.design_system.ui.theme.Gray200
import com.pedro.design_system.ui.theme.Gray300
import com.pedro.design_system.ui.theme.Gray500
import com.pedro.design_system.ui.theme.Gray600

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String? = null,
    @DrawableRes iconRes: Int? = null,
    sizeCustomButton: SizeCustomButton,
    typeCustomButton: TypeCustomButton,
) {
    val heightIn = when (sizeCustomButton) {
        SizeCustomButton.Small -> 28.dp
        SizeCustomButton.Large -> 40.dp
    }

    val iconSize = when (sizeCustomButton) {
        SizeCustomButton.Small -> 14.dp
        SizeCustomButton.Large -> 18.dp
    }

    val containerColor = when (typeCustomButton) {
        TypeCustomButton.Primary -> Gray200
        TypeCustomButton.Secondary -> Gray500
        TypeCustomButton.Link -> Color.Transparent
    }

    val iconTextColor = when (typeCustomButton) {
        TypeCustomButton.Primary -> Gray600
        TypeCustomButton.Secondary -> Gray200
        TypeCustomButton.Link -> Gray300
    }

    Button(
        modifier = modifier
            .heightIn(min = heightIn)
            .then(
                if (text == null) {
                    Modifier.size(heightIn)
                } else Modifier
            ),
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor
        ),
        contentPadding = if (text == null && iconRes != null) PaddingValues(0.dp) else ButtonDefaults.ContentPadding,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            iconRes?.let {
                Icon(
                    modifier = Modifier.size(iconSize),
                    painter = painterResource(id = iconRes),
                    contentDescription = "Icone do botão",
                    tint = iconTextColor
                )
            }
            text?.let {
                Text(
                    text = text,
                    style = CustomTypography.textXs.copy(fontWeight = FontWeight.Bold),
                    color = iconTextColor
                )
            }
        }
    }
}

@Composable
fun CustomButtonSkeleton(
    modifier: Modifier = Modifier,
    sizeCustomButton: SizeCustomButton,
) {
    val heightIn = when (sizeCustomButton) {
        SizeCustomButton.Small -> 28.dp
        SizeCustomButton.Large -> 40.dp
    }


    Box(
        modifier = modifier
            .size(heightIn)
            .background(brush = rememberSkeletonBrush(), shape = RoundedCornerShape(5.dp)),
    )
}

enum class SizeCustomButton {
    Small,
    Large
}

enum class TypeCustomButton {
    Primary,
    Secondary,
    Link
}


@Preview
@Composable
private fun CustomButtonPrev1() {
    CustomButton(
        onClick = {},
        text = "Label",
        sizeCustomButton = SizeCustomButton.Large,
        iconRes = R.drawable.pen_line,
        typeCustomButton = TypeCustomButton.Primary
    )
}

@Preview
@Composable
private fun CustomButtonPrev2() {
    CustomButton(
        onClick = {},
        sizeCustomButton = SizeCustomButton.Large,
        iconRes = R.drawable.pen_line,
        typeCustomButton = TypeCustomButton.Primary
    )
}

@Preview
@Composable
private fun CustomButtonPrev3() {
    CustomButton(
        onClick = {},
        text = "Label",
        sizeCustomButton = SizeCustomButton.Small,
        iconRes = R.drawable.pen_line,
        typeCustomButton = TypeCustomButton.Primary
    )
}

@Preview
@Composable
private fun CustomButtonPrev4() {
    CustomButton(
        onClick = {},
        sizeCustomButton = SizeCustomButton.Small,
        iconRes = R.drawable.pen_line,
        typeCustomButton = TypeCustomButton.Primary
    )
}

@Preview
@Composable
private fun CustomButtonSkeletonPrev1() {
    CustomButtonSkeleton(sizeCustomButton = SizeCustomButton.Small)
}

@Preview
@Composable
private fun CustomButtonSkeletonPrev2() {
    CustomButtonSkeleton(sizeCustomButton = SizeCustomButton.Large)
}