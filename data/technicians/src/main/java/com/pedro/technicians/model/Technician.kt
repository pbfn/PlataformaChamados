package com.pedro.technicians.model

data class Technician(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val availabilities: List<String>
)
