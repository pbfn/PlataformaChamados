package com.pedro.technicians.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.R
import com.pedro.design_system.ui.components.buttons.CustomButton
import com.pedro.design_system.ui.components.buttons.SizeCustomButton
import com.pedro.design_system.ui.components.buttons.TypeCustomButton
import com.pedro.design_system.ui.theme.BlueDark
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.technicians.components.BoxTechnicians
import com.pedro.technicians.model.TechnicianUI
import com.pedro.technicians.states.ListTechniciansUiState


@Composable
fun ListTechniciansScreen(
    modifier: Modifier = Modifier,
    state: ListTechniciansUiState,
    onClickAddTechnician: () -> Unit,
    onClickEditTechnician: (TechnicianUI) -> Unit
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
            listTechnicians = state.listTechnicians,
            onClickEditTechnician = onClickEditTechnician,
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun TechnicianScreenPreview() {
    ListTechniciansScreen(
        onClickAddTechnician = {},
        onClickEditTechnician = {},
        state = ListTechniciansUiState()
    )
}