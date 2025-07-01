package com.pedro.technicians.model

import kotlinx.serialization.Serializable

@Serializable
data class TechnicianUI(
    val id: Int = 0, // TODO ALTERAR
    val name: String,
    val availabilities: List<String>
)
