package com.pedro.technicians.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pedro.design_system.R
import com.pedro.design_system.ui.components.buttons.CustomButton
import com.pedro.design_system.ui.components.buttons.CustomButtonSkeleton
import com.pedro.design_system.ui.components.buttons.SizeCustomButton
import com.pedro.design_system.ui.components.buttons.TypeCustomButton
import com.pedro.design_system.ui.components.tags.TagTime
import com.pedro.design_system.ui.components.tags.TagTimeSkeleton
import com.pedro.design_system.ui.components.util.rememberSkeletonBrush
import com.pedro.design_system.ui.theme.BlueDark
import com.pedro.design_system.ui.theme.CustomTypography
import com.pedro.design_system.ui.theme.Gray200
import com.pedro.design_system.ui.theme.Gray500
import com.pedro.design_system.ui.theme.Gray600
import com.pedro.design_system.ui.utils.getTwoInitialsAlways
import com.pedro.technicians.model.TechnicianUI
import com.pedro.technicians.model.mockListTechnicians

@Composable
fun ItemBoxTechnician(
    technician: TechnicianUI,
    onClickEditTechnician: (TechnicianUI) -> Unit,
) {

    HorizontalDivider(color = Gray500)
    Row(
        Modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(start = 12.dp)
                .fillMaxHeight()
                .weight(0.6f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(color = BlueDark, shape = RoundedCornerShape(50))
                    .size(28.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    getTwoInitialsAlways(technician.name),
                    style = CustomTypography.textSm.copy(fontSize = 12.25.sp),
                    color = Gray600
                )
            }

            Text(
                text = technician.name,
                style = CustomTypography.textSm.copy(
                    fontWeight = FontWeight.Bold,
                    color = Gray200
                ),
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier
                .padding(start = 12.dp)
                .fillMaxHeight()
                .weight(0.4f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            val availabilities = technician.morningAvailabilities + technician.afternoonAvailabilities + technician.nightAvailabilities

            if (availabilities.isNotEmpty())
                TagTime(
                    isReadyOnly = true,
                    isSelected = false,
                    label = availabilities.first(),
                    onClick = {}
                )

            if (availabilities.size > 1) {

                TagTime(
                    isReadyOnly = true,
                    isSelected = false,
                    label = "+${availabilities.size - 1}",
                    onClick = {}
                )
            }

        }


        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomButton(
                typeCustomButton = TypeCustomButton.Secondary,
                sizeCustomButton = SizeCustomButton.Small,
                iconRes = R.drawable.pen_line,
                onClick = {
                    onClickEditTechnician(technician)
                }
            )
        }

    }
}


@Composable
fun ItemBoxTechnicianSkeleton() {
    HorizontalDivider(color = Gray500)
    Row(
        Modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(start = 12.dp)
                .fillMaxHeight()
                .weight(0.6f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(brush = rememberSkeletonBrush(), shape = RoundedCornerShape(50))
                    .size(28.dp),
                contentAlignment = Alignment.Center
            ) {

            }

            Text(
                modifier = Modifier
                    .weight(1f)
                    .background(brush = rememberSkeletonBrush(), shape = RoundedCornerShape(5.dp)),
                text = ""
            )
        }

        Row(
            modifier = Modifier
                .padding(start = 12.dp)
                .fillMaxHeight()
                .weight(0.4f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            TagTimeSkeleton()
        }


        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomButtonSkeleton(
                sizeCustomButton = SizeCustomButton.Small,
            )

        }

    }
}


@Preview(showBackground = true)
@Composable
private fun ItemBoxTechnicianPreview() {
    ItemBoxTechnician(
        technician = mockListTechnicians.first(),
        onClickEditTechnician = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun ItemBoxTechnicianSkeletonPreview() {
    ItemBoxTechnicianSkeleton()
}