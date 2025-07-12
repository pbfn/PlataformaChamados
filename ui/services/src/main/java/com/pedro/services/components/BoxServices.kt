package com.pedro.services.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.design_system.ui.theme.Gray400
import com.pedro.design_system.ui.theme.Gray500
import com.pedro.services.model.ServiceUI
import com.pedro.services.model.mockedListServices

@Composable
fun BoxServices(
    listServices: List<ServiceUI>,
    onClickChangeStatusService: (serviceUI: ServiceUI) -> Unit,
    onClickEditService: (serviceUI: ServiceUI) -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(width = 1.dp, color = Gray500, shape = RoundedCornerShape(10.dp))
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Título",
                    style = CustomTypography.textSm.copy(
                        color = Gray400,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1.5f)
                )
                Text(
                    text = "Valor",
                    style = CustomTypography.textSm.copy(
                        color = Gray400,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .weight(1f)
                )

                Text(
                    text = "Status",
                    style = CustomTypography.textSm.copy(
                        color = Gray400,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1.5f)
                )
            }

            listServices.forEach { service ->
                ItemBoxServices(service, onClickChangeStatusService, onClickEditService)
            }

        }
    }

}

@Preview
@Composable
private fun BoxServicesPrev() {
    BoxServices(listServices = mockedListServices, {}, {})
}