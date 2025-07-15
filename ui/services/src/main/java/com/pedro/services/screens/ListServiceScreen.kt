package com.pedro.services.screens

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
import com.pedro.services.components.BoxServices
import com.pedro.services.components.CreateServiceDialog
import com.pedro.services.model.ServiceUI
import com.pedro.services.model.mockedListServices
import com.pedro.services.states.ListServiceUiState

@Composable
fun ListServiceScreen(
    modifier: Modifier = Modifier,
    state: ListServiceUiState,
    onClickChangeStatusService: (serviceUI: ServiceUI) -> Unit,
    onClickEditService: (serviceUI: ServiceUI) -> Unit,
    onCreateService: () -> Unit,
    onSaveService: () -> Unit,
    onDismissDialogCreateService: () -> Unit,
    onChangeServiceValue: (String) -> Unit,
    onChangeServiceName: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        when (state) {
            is ListServiceUiState.Error -> {}
            ListServiceUiState.Loading -> {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Serviços",
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
                            //
                            // ItemBoxTechnicianSkeleton()
                        }
                    }

                }
            }

            is ListServiceUiState.Success -> {

                if (state.showCreateServiceDialog)
                    CreateServiceDialog(
                        onDismiss = {
                            onDismissDialogCreateService()
                        },
                        onSave = {
                            onSaveService()
                        },
                        serviceName = state.serviceName,
                        serviceValue = state.serviceValue,
                        isSaving = state.isSaving,
                        onChangeServiceName = {
                            onChangeServiceName(it)
                        },
                        onChangeServiceValue = {
                            onChangeServiceValue(it)
                        }
                    )

                Column(
                    modifier = modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Serviços",
                            style = CustomTypography.textLg,
                            color = BlueDark,
                            modifier = Modifier.weight(1f)
                        )
                        CustomButton(
                            typeCustomButton = TypeCustomButton.Primary,
                            sizeCustomButton = SizeCustomButton.Large,
                            iconRes = R.drawable.plus,
                            onClick = {
                                onCreateService()
                            }
                        )
                    }
                    BoxServices(
                        listServices = state.listServices,
                        onClickEditService = {
                            onClickEditService(it)
                        },
                        onClickChangeStatusService = {
                            onClickChangeStatusService(it)
                        }
                    )
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun ListServiceScreenPreview() {
    ListServiceScreen(
        state = ListServiceUiState.Success(
            listServices = mockedListServices
        ),
        onClickEditService = {},
        onClickChangeStatusService = {},
        onCreateService = {},
        onDismissDialogCreateService = {},
        onSaveService = {},
        onChangeServiceValue = {},
        onChangeServiceName = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun ListServiceScreenPreview1() {
    ListServiceScreen(
        state = ListServiceUiState.Loading,
        onClickEditService = {},
        onClickChangeStatusService = {},
        onCreateService = {},
        onDismissDialogCreateService = {},
        onSaveService = {},
        onChangeServiceValue = {},
        onChangeServiceName = {}
    )
}