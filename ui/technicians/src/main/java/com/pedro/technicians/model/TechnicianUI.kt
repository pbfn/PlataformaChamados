package com.pedro.technicians.model

import kotlinx.serialization.Serializable

@Serializable
data class TechnicianUI(
    val id: Int,
    val name: String,
    val availabilities: List<String>
)
