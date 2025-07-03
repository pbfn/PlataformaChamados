package com.pedro.technicians.model

data class TechnicianDomain(
    val id: Int,
    val name: String,
    val email: String,
    val availabilities: List<String>
)
