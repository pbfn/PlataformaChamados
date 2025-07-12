package com.pedro.services.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.R
import com.pedro.design_system.ui.components.buttons.CustomButton
import com.pedro.design_system.ui.components.buttons.SizeCustomButton
import com.pedro.design_system.ui.components.buttons.TypeCustomButton
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.design_system.ui.theme.Gray400
import com.pedro.design_system.ui.theme.Gray500
import com.pedro.services.model.ServiceUI
import com.pedro.services.model.mockedListServices

@Composable
fun ItemBoxServices(
    service: ServiceUI,
    onClickChangeStatusService: (serviceUI: ServiceUI) -> Unit,
    onClickEditService: (serviceUI: ServiceUI) -> Unit,
) {

    val icon = if (service.isActive) R.drawable.ban else R.drawable.circle_check

    HorizontalDivider(color = Gray500)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = service.title,
            style = CustomTypography.textSm.copy(
                color = Gray400,
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1.6f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "R$ ${service.value}",
            style = CustomTypography.textSm.copy(
                color = Gray400,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1.5f)
        )

        Row(
            modifier = Modifier
                .padding(end = 8.dp)
                .weight(1.5f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconStatus(isActive = service.isActive)

            Spacer(modifier = Modifier.weight(1f))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(
                    modifier = Modifier.size(20.dp),
                    onClick = { onClickChangeStatusService(service) }
                ) {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = "icon_change_status",
                        modifier = Modifier.size(14.dp)
                    )
                }
                CustomButton(
                    typeCustomButton = TypeCustomButton.Secondary,
                    sizeCustomButton = SizeCustomButton.Small,
                    iconRes = R.drawable.pen_line,
                    onClick = {
                        onClickEditService(service)
                    }
                )
            }

        }
    }

}

@Preview
@Composable
private fun ItemBoxServicesPreview() {
    ItemBoxServices(service = mockedListServices.first(), {}, {})
}

@Preview
@Composable
private fun ItemBoxServicesPreview2() {
    ItemBoxServices(service = mockedListServices[1], {}, {})
}