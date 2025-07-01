package com.pedro.technicians.states.profile

data class BoxOpeningHoursUiState(
    val listMorningHours: List<String> = listOf(),
    val listMorningSelected: List<String> = listOf(),
    val listAfternoonHours: List<String> = listOf(),
    val listAfternoonSelected: List<String> = listOf(),
    val listNightHours: List<String> = listOf(),
    val listNightSelected: List<String> = listOf()
)
