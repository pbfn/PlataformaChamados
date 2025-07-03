package com.pedro.technicians.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.R
import com.pedro.design_system.ui.components.buttons.CustomButton
import com.pedro.design_system.ui.components.buttons.CustomButtonSkeleton
import com.pedro.design_system.ui.components.buttons.SizeCustomButton
import com.pedro.design_system.ui.components.buttons.TypeCustomButton
import com.pedro.design_system.ui.components.util.rememberSkeletonBrush
import com.pedro.design_system.ui.theme.BlueDark
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.design_system.ui.theme.Gray500
import com.pedro.technicians.components.BoxTechnicians
import com.pedro.technicians.components.ItemBoxTechnicianSkeleton
import com.pedro.technicians.model.TechnicianUI
import com.pedro.technicians.states.ListTechniciansUiState


@Composable
fun ListTechniciansScreen(
    modifier: Modifier = Modifier,
    state: ListTechniciansUiState,
    onClickAddTechnician: () -> Unit,
    onClickEditTechnician: (TechnicianUI) -> Unit
) {

    when (state) {
        is ListTechniciansUiState.Error -> {}
        ListTechniciansUiState.Loading -> {
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
                    CustomButtonSkeleton(sizeCustomButton = SizeCustomButton.Large)
                }

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
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(horizontal = 12.dp)
                                    .weight(1f)
                                    .background(
                                        brush = rememberSkeletonBrush(),
                                        shape = RoundedCornerShape(5.dp)
                                    ),
                                text = ""
                            )
                            Text(
                                modifier = Modifier
                                    .padding(horizontal = 12.dp)
                                    .weight(1f)
                                    .background(
                                        brush = rememberSkeletonBrush(),
                                        shape = RoundedCornerShape(5.dp)
                                    ),
                                text = ""
                            )
                        }
                        repeat(10) {
                            ItemBoxTechnicianSkeleton()
                        }
                    }

                }
            }
        }

        is ListTechniciansUiState.Success -> {
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
    }


}


@Preview(showBackground = true)
@Composable
private fun TechnicianScreenPreview() {
    ListTechniciansScreen(
        onClickAddTechnician = {},
        onClickEditTechnician = {},
        state = ListTechniciansUiState.Success(
            listTechnicians = listOf(
                TechnicianUI(
                    id = 1,
                    name = "Pedro Bruno",
                    email = "@gmail.com",
                    availabilities = listOf("08:00", "10:00", "13:00", "15:00")
                ),
                TechnicianUI(
                    id = 2,
                    name = "Rebeca Nantes",
                    email = "rebeca@gmail.com",
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
                    email = "joaopaulo@gmail.com",
                    availabilities = listOf("15:00", "18:00", "21:00", "22:00")
                ),
                TechnicianUI(
                    id = 4,
                    name = "Ricardo",
                    email = "ricardo@gmail.com",
                    availabilities = listOf("16:00")
                ),
            ),
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun TechnicianScreenWithLoadingPreview() {
    ListTechniciansScreen(
        onClickAddTechnician = {},
        onClickEditTechnician = {},
        state = ListTechniciansUiState.Loading
    )
}