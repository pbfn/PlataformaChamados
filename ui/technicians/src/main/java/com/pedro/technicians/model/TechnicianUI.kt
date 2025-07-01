package com.pedro.technicians.model

import kotlinx.serialization.Serializable

@Serializable
data class TechnicianUI(
    val name: String,
    val availabilities: List<String>
)
