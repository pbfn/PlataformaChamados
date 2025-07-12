package com.pedro.services.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.R
import com.pedro.design_system.ui.theme.FeedbackDanger
import com.pedro.design_system.ui.theme.FeedbackDone

@Composable
fun IconStatus(isActive: Boolean) {
    val background = if (isActive) FeedbackDone else FeedbackDanger
    val icon = if (isActive) R.drawable.circle_check else R.drawable.ban
    Box(
        modifier = Modifier
            .size(28.dp)
            .clip(RoundedCornerShape(999.dp))
            .background(background.copy(0.2f)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(icon),
            contentDescription = "icon",
            tint = background
        )
    }
}

@Preview
@Composable
private fun IconStatusPrev() {
    IconStatus(true)
}

@Preview
@Composable
private fun IconStatusPrev2() {
    IconStatus(false)
}