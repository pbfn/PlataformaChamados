package com.pedro.technicians.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.ui.components.CustomBoxWithBorder
import com.pedro.design_system.ui.components.util.rememberSkeletonBrush
import com.pedro.design_system.ui.theme.Gray200
import com.pedro.design_system.ui.theme.Gray300
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.technicians.states.profile.BoxOpeningHoursUiState

@Composable
fun BoxOpeningHours(
    state: BoxOpeningHoursUiState
) {
    CustomBoxWithBorder {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Horários de atendimento",
                style = CustomTypography.textLg,
                color = Gray200
            )
            Text(
                text = "Selecione os horários de disponibilidade do técnico para atendimento",
                style = CustomTypography.textXs,
                color = Gray300
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            BoxHours(
                title = "Manhã",
                listHours = state.listMorningHours,
                listSelectedHour = state.listMorningSelected,
                onSelectedHour = {},
            )
            BoxHours(
                title = "Tarde",
                listHours = state.listAfternoonHours,
                listSelectedHour = state.listAfternoonSelected,
                onSelectedHour = {},
            )
            BoxHours(
                title = "Noite",
                listHours = state.listNightHours,
                listSelectedHour = state.listNightSelected,
                onSelectedHour = {},
            )
        }
    }
}

@Composable
fun BoxOpeningHoursSkeleton() {
    CustomBoxWithBorder {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.background(
                    brush = rememberSkeletonBrush(),
                    RoundedCornerShape(5.dp)
                ),
                color = Color.Transparent,
                text = "Horários de atendimento",
                style = CustomTypography.textLg,
            )
            Text(
                modifier = Modifier.background(
                    brush = rememberSkeletonBrush(),
                    RoundedCornerShape(5.dp)
                ),
                color = Color.Transparent,
                text = "Selecione os horários de disponibilidade do técnico para atendimento",
                style = CustomTypography.textXs,

                )
        }

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            BoxHoursSkeleton()
            BoxHoursSkeleton()
            BoxHoursSkeleton()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BoxOpeningHoursPreview() {
    val listMorningHours = listOf<String>("07:00", "08:00", "09:00", "10:00", "11:00", "12:00")
    val listAfternoonHours = listOf<String>("13:00", "14:00", "15:00", "16:00", "17:00", "18:00")
    val listNightHours = listOf<String>("19:00", "20:00", "21:00", "22:00", "23:00")
    BoxOpeningHours(
        state = BoxOpeningHoursUiState(
            listMorningHours = listMorningHours,
            listMorningSelected = emptyList(),
            listAfternoonHours = listAfternoonHours,
            listAfternoonSelected = emptyList(),
            listNightHours = listNightHours,
            listNightSelected = emptyList()
        )
    )
}

@Preview(showBackground = false)
@Composable
private fun BoxOpeningHoursPreview1() {
    val listMorningHours = listOf<String>("07:00", "08:00", "09:00", "10:00", "11:00", "12:00")
    val listMorningSelected = listOf<String>("07:00", "08:00", "11:00", "12:00")

    val listAfternoonHours = listOf<String>("13:00", "14:00", "15:00", "16:00", "17:00", "18:00")
    val listAfternoonSelected = listOf<String>("14:00", "15:00")

    val listNightHours = listOf<String>("19:00", "20:00", "21:00", "22:00", "23:00")
    val listNightSelected = listOf<String>("23:00")
    BoxOpeningHours(
        state = BoxOpeningHoursUiState(
            listMorningHours = listMorningHours,
            listMorningSelected = listMorningSelected,
            listAfternoonHours = listAfternoonHours,
            listAfternoonSelected = listAfternoonSelected,
            listNightHours = listNightHours,
            listNightSelected = listNightSelected
        )
    )
}