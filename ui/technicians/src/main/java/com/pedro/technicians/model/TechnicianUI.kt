package com.pedro.technicians.model

import kotlinx.serialization.Serializable

@Serializable
data class TechnicianUI(
    val id: Int,
    val name: String,
    val email: String,
    val availabilities: List<String>,
    val morningAvailabilities: List<String> = listOf(),
    val afternoonAvailabilities: List<String> = listOf(),
    val nightAvailabilities: List<String> = listOf(),
)
