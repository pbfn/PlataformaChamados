package com.pedro.technicians.events

sealed class ListTechniciansUiEvents {
    data object OnLoadTechnicians : ListTechniciansUiEvents()
}