package com.pedro.technicians.model

data class TechnicianDomain(
    val id: String = "",
    val name: String,
    val email: String,
    val password: String,
    val morningAvailabilities: List<String>,
    val afternoonAvailabilities: List<String>,
    val nightAvailabilities: List<String>,
)
