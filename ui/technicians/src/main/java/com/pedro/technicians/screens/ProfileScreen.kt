package com.pedro.technicians.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.technicians.components.BoxOpeningHours
import com.pedro.technicians.components.BoxOpeningHoursSkeleton
import com.pedro.technicians.components.BoxPersonalInformation
import com.pedro.technicians.components.BoxPersonalInformationSkeleton
import com.pedro.technicians.components.TopProfileTechnician
import com.pedro.technicians.components.TopProfileTechnicianSkeleton
import com.pedro.technicians.model.HoursType
import com.pedro.technicians.states.profile.BoxOpeningHoursUiState
import com.pedro.technicians.states.profile.BoxPersonalDataUiState
import com.pedro.technicians.states.profile.ProfileUiState

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    state: ProfileUiState,
    onNavigateBack: () -> Unit,
    onSave: () -> Unit,
    onNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onSelectedHour: (String, HoursType) -> Unit,
) {

    val focusManager = LocalFocusManager.current

    when (state) {
        is ProfileUiState.Error -> {}
        ProfileUiState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                ProfileScreenSkeleton()
            }
        }

        is ProfileUiState.Success -> {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TopProfileTechnician(
                    onNavigateBack = { onNavigateBack() },
                    onSave = {
                        onSave()
                    },
                    onCancel = { onNavigateBack() }
                )
                BoxPersonalInformation(
                    state.boxPersonalDataUiState,
                    onNameChanged,
                    focusManager,
                    onEmailChanged,
                    onPasswordChanged,
                )

                BoxOpeningHours(
                    state.boxOpeningHoursUiState,
                    onSelectedHour = { hourSelected, hoursType ->
                        onSelectedHour(hourSelected, hoursType)
                    }
                )

            }

        }
    }


}

@Composable
fun ProfileScreenSkeleton(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        TopProfileTechnicianSkeleton()

        BoxPersonalInformationSkeleton()

        BoxOpeningHoursSkeleton()

    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileTechniciansScreenPreview() {
    val listMorningHours = listOf<String>("07:00", "08:00", "09:00", "10:00", "11:00", "12:00")
    val listAfternoonHours = listOf<String>("13:00", "14:00", "15:00", "16:00", "17:00", "18:00")
    val listNightHours = listOf<String>("19:00", "20:00", "21:00", "22:00", "23:00")


    ProfileScreen(
        state = ProfileUiState.Success(
            boxPersonalDataUiState = BoxPersonalDataUiState(
                isEdit = false,
                helperTextPassword = "Mínimo de 6 dígitos",
            ),
            boxOpeningHoursUiState = BoxOpeningHoursUiState(
                listMorningHours = listMorningHours,
                listMorningSelected = emptyList(),
                listAfternoonHours = listAfternoonHours,
                listAfternoonSelected = emptyList(),
                listNightHours = listNightHours,
                listNightSelected = emptyList(),
            )
        ),
        onNavigateBack = {},
        onNameChanged = { },
        onEmailChanged = {},
        onSave = {},
        onPasswordChanged = {},
        onSelectedHour = { hourSelected, hoursType ->

        }
    )
}


@Preview(showBackground = true)
@Composable
private fun ProfileTechniciansScreenPreview1() {
    val listMorningHours = listOf<String>("07:00", "08:00", "09:00", "10:00", "11:00", "12:00")
    val listMorningSelected = listOf<String>("07:00", "08:00", "11:00", "12:00")

    val listAfternoonHours = listOf<String>("13:00", "14:00", "15:00", "16:00", "17:00", "18:00")
    val listAfternoonSelected = listOf<String>("14:00", "15:00")

    val listNightHours = listOf<String>("19:00", "20:00", "21:00", "22:00", "23:00")
    val listNightSelected = listOf<String>("23:00")
    ProfileScreen(
        state = ProfileUiState.Success(
            boxPersonalDataUiState = BoxPersonalDataUiState(
                isEdit = true,
                helperTextPassword = "Mínimo de 6 dígitos",
            ),
            boxOpeningHoursUiState = BoxOpeningHoursUiState(
                listMorningHours = listMorningHours,
                listMorningSelected = listMorningSelected,
                listAfternoonHours = listAfternoonHours,
                listAfternoonSelected = listAfternoonSelected,
                listNightHours = listNightHours,
                listNightSelected = listNightSelected,
            )
        ),
        onNavigateBack = {},
        onNameChanged = { },
        onEmailChanged = {},
        onPasswordChanged = {},
        onSave = {},
        onSelectedHour = { hourSelected, hoursType ->

        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ProfileTechniciansScreenPreview2() {
    ProfileScreen(
        state = ProfileUiState.Loading,
        onNavigateBack = {},
        onNameChanged = { },
        onEmailChanged = {},
        onPasswordChanged = {},
        onSave = {},
        onSelectedHour = { hourSelected, hoursType ->

        }
    )
}