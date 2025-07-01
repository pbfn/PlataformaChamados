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
        listTechnicians = listOf(
            TechnicianUI(
                id = 1,
                name = "Pedro Bruno",
                availabilities = listOf("08:00", "10:00", "13:00", "15:00")
            ),
            TechnicianUI(
                id = 2,
                name = "Rebeca Nantes",
                availabilities = listOf(
                    "10:00",
                    "11:00",
                    "13:00",
                    "15:00",
                    "18:00",
                    "21:00",
                    "22:00"
                )
            ),
            TechnicianUI(
                id = 3,
                name = "João Paulo",
                availabilities = listOf("15:00", "18:00", "21:00", "22:00")
            ),
            TechnicianUI(
                id = 4,
                name = "Ricardo",
                availabilities = listOf("16:00")
            ),
        ),
        onClickEditTechnician = {}
    )
}