package com.pedro.technicians.model

import kotlinx.serialization.Serializable

@Serializable
data class TechnicianUI(
    val id: Int,
    val name: String,
    val email: String,
    val password: String = "",
    val morningAvailabilities: List<String>,
    val afternoonAvailabilities: List<String>,
    val nightAvailabilities: List<String>,
)


val mockListTechnicians = listOf(
    TechnicianUI(
        id = 1,
        name = "Pedro Bruno",
        email = "@gmail.com",
        morningAvailabilities = listOf("08:00", "10:00"),
        afternoonAvailabilities = listOf("13:00", "15:00"),
        nightAvailabilities = listOf(),
    ),
    TechnicianUI(
        id = 2,
        name = "Rebeca Nantes",
        email = "rebeca@gmail.com",
        morningAvailabilities = listOf("10:00", "11:00"),
        afternoonAvailabilities = listOf("13:00", "15:00"),
        nightAvailabilities = listOf("18:00", "21:00", "22:00"),
    ),
    TechnicianUI(
        id = 3,
        name = "João Paulo",
        email = "joaopaulo@gmail.com",
        morningAvailabilities = listOf(),
        afternoonAvailabilities = listOf("15:00"),
        nightAvailabilities = listOf("18:00", "21:00", "22:00")
    ),
    TechnicianUI(
        id = 4,
        name = "Ricardo",
        email = "ricardo@gmail.com",
        morningAvailabilities = listOf(),
        afternoonAvailabilities = listOf("16:00"),
        nightAvailabilities = listOf()
    ),
)
