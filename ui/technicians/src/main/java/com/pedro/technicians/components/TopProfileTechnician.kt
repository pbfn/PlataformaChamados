package com.pedro.technicians.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.R
import com.pedro.design_system.ui.components.buttons.CustomButton
import com.pedro.design_system.ui.components.buttons.CustomButtonSkeleton
import com.pedro.design_system.ui.components.buttons.SizeCustomButton
import com.pedro.design_system.ui.components.buttons.TypeCustomButton
import com.pedro.design_system.ui.components.util.rememberSkeletonBrush
import com.pedro.design_system.ui.theme.BlueDark
import com.pedro.design_system.ui.theme.Gray300
import com.pedro.design_system.ui.theme.CustomTypography

@Composable
fun TopProfileTechnician(
    onNavigateBack: () -> Unit,
    onSave: () -> Unit,
    onCancel: () -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    modifier = Modifier.size(14.dp),
                    onClick = {
                        onNavigateBack()
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.arrow_left),
                        contentDescription = "arrow back",
                        modifier = Modifier.size(14.dp),
                        tint = Gray300
                    )
                }

                Text(
                    text = "Voltar",
                    style = CustomTypography.textXxs.copy(color = Gray300)
                )
            }
            Text(
                text = "Perfil de técnico",
                style = CustomTypography.textLg.copy(color = BlueDark)
            )
        }


        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomButton(
                modifier = Modifier.weight(1f),
                onClick = {
                    onCancel()
                },
                sizeCustomButton = SizeCustomButton.Large,
                typeCustomButton = TypeCustomButton.Secondary,
                text = "Cancelar"
            )
            CustomButton(
                modifier = Modifier.weight(1f),
                onClick = {
                    onSave()
                },
                sizeCustomButton = SizeCustomButton.Large,
                typeCustomButton = TypeCustomButton.Primary,
                text = "Salvar"
            )
        }
    }
}

@Composable
fun TopProfileTechnicianSkeleton() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                modifier = Modifier.background(
                    brush = rememberSkeletonBrush(),
                    RoundedCornerShape(5.dp)
                ),
                color = Color.Transparent,
                text = "Perfil de técnico",
                style = CustomTypography.textLg
            )
        }


        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomButtonSkeleton(
                sizeCustomButton = SizeCustomButton.Large,
                modifier = Modifier.weight(1f),
            )
            CustomButtonSkeleton(
                sizeCustomButton = SizeCustomButton.Large,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TopProfileTechnicianPrev() {
    TopProfileTechnician(
        onNavigateBack = {},
        onSave = {},
        onCancel = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun TopProfileTechnicianSkeletonPrev() {
    TopProfileTechnicianSkeleton()
}