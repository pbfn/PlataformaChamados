package com.pedro.technicians.model.remote

data class TechnicianRemote(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
    val availabilities: List<String>
)
