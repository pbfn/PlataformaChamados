package com.pedro.technicians.components

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
import com.pedro.design_system.ui.theme.Gray400
import com.pedro.design_system.ui.theme.Gray500
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.technicians.model.TechnicianUI
import com.pedro.technicians.model.mockListTechnicians

@Composable
fun BoxTechnicians(
    listTechnicians: List<TechnicianUI>,
    onClickEditTechnician: (TechnicianUI) -> Unit,
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
                    text = "Nome",
                    style = CustomTypography.textSm.copy(
                        color = Gray400,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .weight(1f)
                )
                Text(
                    text = "Disponibilidade",
                    style = CustomTypography.textSm.copy(
                        color = Gray400,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .weight(1f)
                )
            }

            listTechnicians.forEach { technician ->
                ItemBoxTechnician(technician, onClickEditTechnician = onClickEditTechnician)
            }

        }
    }
}

@Preview
@Composable
private fun BoxTechniciansPreview() {
    BoxTechnicians(
        listTechnicians = mockListTechnicians,
        onClickEditTechnician = {}
    )
}