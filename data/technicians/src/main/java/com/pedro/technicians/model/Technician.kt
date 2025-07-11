package com.pedro.technicians.model

data class Technician(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
    val availabilities: List<String>
)
