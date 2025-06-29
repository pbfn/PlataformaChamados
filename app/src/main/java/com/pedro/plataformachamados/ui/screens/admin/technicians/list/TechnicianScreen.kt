package com.pedro.plataformachamados.ui.screens.admin.technicians.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.plataformachamados.R
import com.pedro.plataformachamados.data.model.Technician
import com.pedro.design_system.ui.components.buttons.CustomButton
import com.pedro.design_system.ui.components.buttons.SizeCustomButton
import com.pedro.design_system.ui.components.buttons.TypeCustomButton
import com.pedro.plataformachamados.ui.components.technician.BoxTechnicians
import com.pedro.design_system.ui.theme.BlueDark
import com.pedro.design_system.ui.theme.CustomTypography


@Composable
fun TechnicianScreen(
    modifier: Modifier = Modifier,
    onClickAddTechnician: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Técnicos",
                style = CustomTypography.textLg,
                color = BlueDark,
                modifier = Modifier.weight(1f)
            )
            CustomButton(
                typeCustomButton = TypeCustomButton.Primary,
                sizeCustomButton = SizeCustomButton.Large,
                iconRes = R.drawable.plus,
                onClick = {
                    onClickAddTechnician()
                }
            )
        }

        BoxTechnicians(
            listTechnicians = listOf(
                Technician(
                    name = "Pedro Bruno",
                    availabilities = listOf("08:00", "10:00", "13:00", "15:00")
                ),
                Technician(
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

                Technician(
                    name = "João Paulo",
                    availabilities = listOf("15:00", "18:00", "21:00", "22:00")
                ),
                Technician(
                    name = "Ricardo",
                    availabilities = listOf("16:00")
                ),
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun TechnicianScreenPreview() {
    TechnicianScreen(
        onClickAddTechnician = {}
    )
}