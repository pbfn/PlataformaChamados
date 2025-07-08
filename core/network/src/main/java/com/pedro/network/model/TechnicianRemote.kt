package com.pedro.network.model

data class TechnicianFireStore(
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val availabilities: List<String> = listOf()
)
