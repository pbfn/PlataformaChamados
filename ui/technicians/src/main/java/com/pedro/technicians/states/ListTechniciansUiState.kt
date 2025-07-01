package com.pedro.technicians.states

import com.pedro.technicians.model.TechnicianUI

data class ListTechniciansUiState(
    val listTechnicians: List<TechnicianUI> = listOf(
        TechnicianUI(
            name = "Pedro Bruno",
            availabilities = listOf("08:00", "10:00", "13:00", "15:00")
        ),
        TechnicianUI(
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

        TechnicianUI(
            name = "João Paulo",
            availabilities = listOf("15:00", "18:00", "21:00", "22:00")
        ),
        TechnicianUI(
            name = "Ricardo",
            availabilities = listOf("16:00")
        ),
    )
)
