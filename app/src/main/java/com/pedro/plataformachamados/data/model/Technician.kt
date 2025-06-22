package com.pedro.plataformachamados.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Technician(
    val name: String,
    val availabilities: List<String>
)
