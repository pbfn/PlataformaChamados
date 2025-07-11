package com.pedro.technicians.model

enum class HoursPeriod(val hours: List<String>) {
    MORNING(listOf("07:00", "08:00", "09:00", "10:00", "11:00", "12:00")),
    AFTERNOON(listOf("13:00", "14:00", "15:00", "16:00", "17:00", "18:00")),
    NIGHT(listOf("19:00", "20:00", "21:00", "22:00", "23:00"))
}

fun List<String>.filterByPeriod(period: HoursPeriod): List<String> {
    return this.filter { hour -> period.hours.any { hour.contains(it) } }
}