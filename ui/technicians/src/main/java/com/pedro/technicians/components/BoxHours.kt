package com.pedro.technicians.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.ui.components.tags.TagTime
import com.pedro.design_system.ui.theme.Gray300
import com.pedro.design_system.ui.theme.CustomTypography

@Composable
@OptIn(ExperimentalLayoutApi::class)
fun BoxHours(
    title: String,
    listHours: List<String>,
    listSelectedHour: List<String>,
    onSelectedHour: (String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = title.uppercase(),
            style = CustomTypography.textXxs.copy(color = Gray300)
        )

        FlowRow(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            listHours.forEach { item ->
                TagTime(
                    isReadyOnly = false,
                    isSelected = listSelectedHour.contains(item),
                    label = item
                ) {
                    onSelectedHour(item)
                }
            }
        }
    }
}

@Preview
@Composable
private fun BoxHoursPrev() {
    val listMorningHours = listOf<String>("07:00", "08:00", "09:00", "10:00", "11:00", "12:00")
    val listMorningSelected = listOf<String>("07:00", "08:00", "11:00", "12:00")
    BoxHours(
        title = "Manhã",
        listHours = listMorningHours,
        listSelectedHour = listMorningSelected,
        onSelectedHour = {}
    )
}