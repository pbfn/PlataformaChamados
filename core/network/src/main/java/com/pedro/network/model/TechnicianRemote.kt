package com.pedro.network.model

data class TechnicianFireStore(
    val id: Int,
    val name: String,
    val email: String,
    val availabilities: List<String>
)
