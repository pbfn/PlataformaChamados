package com.pedro.plataformachamados.ui.screens.admin.technicians.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.plataformachamados.ui.components.technician.BoxOpeningHours
import com.pedro.plataformachamados.ui.components.technician.BoxPersonalInformation
import com.pedro.plataformachamados.ui.components.technician.TopProfileTechnician

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileTechniciansScreen(
    modifier: Modifier = Modifier,
    isEdit: Boolean,
    onNavigateBack: () -> Unit,
    name: String,
    onNameChanged: (String) -> Unit,
    helperTextName: String,
    nameHasError: Boolean,
    email: String,
    onEmailChanged: (String) -> Unit,
    helperTextEmail: String,
    emailHasError: Boolean,
    password: String,
    onPasswordChanged: (String) -> Unit,
    helperTextPassword: String,
    passwordHasError: Boolean,
    listMorningHours: List<String>,
    listMorningSelected: List<String>,
    listAfternoonHours: List<String>,
    listAfternoonSelected: List<String>,
    listNightHours: List<String>,
    listNightSelected: List<String>,
) {

    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        TopProfileTechnician(
            onNavigateBack = { onNavigateBack() },
            onSave = {},
            onCancel = { onNavigateBack() }
        )

        BoxPersonalInformation(
            isEdit,
            name,
            onNameChanged,
            helperTextName,
            nameHasError,
            focusManager,
            onEmailChanged,
            helperTextEmail,
            email,
            emailHasError,
            onPasswordChanged,
            helperTextPassword,
            password,
            passwordHasError
        )

        BoxOpeningHours(
            listMorningHours,
            listMorningSelected,
            listAfternoonHours,
            listAfternoonSelected,
            listNightHours,
            listNightSelected
        )

    }
}


@Preview(showBackground = true)
@Composable
private fun ProfileTechniciansScreenPreview() {
    val listMorningHours = listOf<String>("07:00", "08:00", "09:00", "10:00", "11:00", "12:00")
    val listAfternoonHours = listOf<String>("13:00", "14:00", "15:00", "16:00", "17:00", "18:00")
    val listNightHours = listOf<String>("19:00", "20:00", "21:00", "22:00", "23:00")


    ProfileTechniciansScreen(
        isEdit = false,
        onNavigateBack = {},
        name = "",
        onNameChanged = { },
        helperTextName = "",
        nameHasError = false,
        email = "",
        onEmailChanged = {},
        helperTextEmail = "",
        emailHasError = false,
        password = "",
        onPasswordChanged = {},
        helperTextPassword = "Mínimo de 6 dígitos",
        passwordHasError = false,
        listMorningHours = listMorningHours,
        listMorningSelected = emptyList(),
        listAfternoonHours = listAfternoonHours,
        listAfternoonSelected = emptyList(),
        listNightHours = listNightHours,
        listNightSelected = emptyList(),
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
    ProfileTechniciansScreen(
        isEdit = true,
        onNavigateBack = {},
        name = "Pedro Bruno Fernandes",
        onNameChanged = { },
        helperTextName = "",
        nameHasError = false,
        email = "pedro.bruno@test.com",
        onEmailChanged = {},
        helperTextEmail = "",
        emailHasError = false,
        password = "",
        onPasswordChanged = {},
        helperTextPassword = "Mínimo de 6 dígitos",
        passwordHasError = false,
        listMorningHours = listMorningHours,
        listMorningSelected = listMorningSelected,
        listAfternoonHours = listAfternoonHours,
        listAfternoonSelected = listAfternoonSelected,
        listNightHours = listNightHours,
        listNightSelected = listNightSelected,
    )
}