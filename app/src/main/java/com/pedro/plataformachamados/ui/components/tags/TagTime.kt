package com.pedro.plataformachamados.ui.components.tags

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.plataformachamados.R
import com.pedro.plataformachamados.ui.theme.BlueBase
import com.pedro.plataformachamados.ui.theme.Gray200
import com.pedro.plataformachamados.ui.theme.Gray400
import com.pedro.plataformachamados.ui.theme.Gray500
import com.pedro.plataformachamados.ui.theme.Gray600
import com.pedro.plataformachamados.ui.theme.TypographyPersonalizada

@Composable
fun TagTime(
    modifier: Modifier = Modifier,
    isReadyOnly: Boolean,
    isSelected: Boolean,
    label: String,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    val borderColor = when {
        isReadyOnly -> Gray500
        isSelected -> Color.Transparent
        else -> Gray400
    }

    val backgroundColor = when {
        isSelected -> BlueBase
        isReadyOnly -> Color.Transparent
        else -> Color.Transparent
    }

    val fontColor = when {
        isSelected -> Gray600
        isReadyOnly -> Gray400
        else -> Gray200
    }

    Box(
        modifier = modifier

            .height(28.dp)
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(999.dp))
            .background(color = backgroundColor, shape = RoundedCornerShape(999.dp))
            .clip(RoundedCornerShape(999.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = {
                    onClick()
                }
            )
            .padding(6.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 3.dp, vertical = 0.5.dp),
                text = label,
                style = TypographyPersonalizada.textXs.copy(
                    fontWeight = FontWeight.Bold,
                    color = fontColor,
                    textAlign = TextAlign.Center
                ),
            )
            if (isSelected) {
                Icon(
                    painter = painterResource(R.drawable.x),
                    contentDescription = "Clear Icon",
                    modifier = Modifier.size(14.dp),
                    tint = Color.White
                )
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
private fun TagTimePreview() {
    TagTime(
        isReadyOnly = false,
        isSelected = false,
        label = "Label",
        onClick = {},
    )
}


@Preview(showBackground = true)
@Composable
private fun TagTimePreview1() {
    TagTime(
        isReadyOnly = false,
        isSelected = true,
        label = "Label",
        onClick = {},
    )
}

@Preview(showBackground = true)
@Composable
private fun TagTimePreview2() {
    TagTime(
        isReadyOnly = true,
        isSelected = false,
        label = "Label",
        onClick = {},
    )
}