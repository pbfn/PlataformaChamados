package com.pedro.design_system.ui.components.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.R
import com.pedro.design_system.ui.components.util.rememberSkeletonBrush
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.design_system.ui.theme.FeedbackDanger
import com.pedro.design_system.ui.theme.FeedbackDone
import com.pedro.design_system.ui.theme.FeedbackOpen
import com.pedro.design_system.ui.theme.FeedbackProgress

@Composable
fun TagStatus(
    modifier: Modifier = Modifier,
    showText: Boolean,
    label: String? = null,
    type: TypeTagStatus
) {

    val icon = when (type) {
        TypeTagStatus.NEW -> R.drawable.circle_help
        TypeTagStatus.INFO -> R.drawable.clock_2
        TypeTagStatus.SUCCESS -> R.drawable.circle_check
        TypeTagStatus.DANGER -> R.drawable.circle_help
    }

    val backgroundColor = when (type) {
        TypeTagStatus.NEW -> FeedbackOpen.copy(alpha = 0.2f)
        TypeTagStatus.INFO -> FeedbackProgress.copy(alpha = 0.2f)
        TypeTagStatus.SUCCESS -> FeedbackDone.copy(alpha = 0.2f)
        TypeTagStatus.DANGER -> FeedbackDanger.copy(alpha = 0.2f)
    }

    val fontColor = when (type) {
        TypeTagStatus.NEW -> FeedbackOpen
        TypeTagStatus.INFO -> FeedbackProgress
        TypeTagStatus.SUCCESS -> FeedbackDone
        TypeTagStatus.DANGER -> FeedbackDanger
    }

    Box(
        modifier = modifier
            .height(28.dp)
            .border(width = 1.dp, color = Color.Transparent, shape = RoundedCornerShape(999.dp))
            .background(color = backgroundColor, shape = RoundedCornerShape(999.dp))
            .clip(RoundedCornerShape(999.dp))
            .padding(6.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = "Icon",
                modifier = Modifier.size(16.dp),
                tint = fontColor
            )
            if (label != null && showText) {
                Text(
                    modifier = Modifier.padding(horizontal = 3.dp, vertical = 0.5.dp),
                    text = label,
                    style = CustomTypography.textXs.copy(
                        fontWeight = FontWeight.Bold,
                        color = fontColor,
                        textAlign = TextAlign.Center
                    ),
                )
            }
        }
    }


}


@Composable
fun TagStatusSkeleton(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .height(28.dp)
            .border(width = 1.dp, color = Color.Transparent, shape = RoundedCornerShape(999.dp))
            .background(brush = rememberSkeletonBrush(), shape = RoundedCornerShape(999.dp))
            .clip(RoundedCornerShape(999.dp))
            .padding(6.dp)
    ) {
        Box(modifier = Modifier
            .clip(RoundedCornerShape(999.dp))
            .size(16.dp))
    }
}

@Preview
@Composable
private fun TagStatusPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        TagStatus(
            showText = true,
            label = "Label",
            type = TypeTagStatus.NEW
        )
        TagStatus(
            showText = true,
            label = "Label",
            type = TypeTagStatus.INFO
        )
        TagStatus(
            showText = true,
            label = "Label",
            type = TypeTagStatus.SUCCESS
        )
        TagStatus(
            showText = true,
            label = "Label",
            type = TypeTagStatus.DANGER
        )
    }

}

@Preview
@Composable
private fun TagStatusPreview1() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        TagStatus(
            showText = false,
            type = TypeTagStatus.NEW
        )
        TagStatus(
            showText = false,
            type = TypeTagStatus.INFO
        )
        TagStatus(
            showText = false,
            type = TypeTagStatus.SUCCESS
        )
        TagStatus(
            showText = false,
            type = TypeTagStatus.DANGER
        )
    }

}

@Preview
@Composable
fun TagStatusSkeletonPreview() {
    TagStatusSkeleton()
}


enum class TypeTagStatus {
    NEW,
    INFO,
    SUCCESS,
    DANGER
}