package com.pedro.services.model

data class ServiceUI(
    val id: String,
    val title: String,
    val value: Double,
    val isActive: Boolean
)


val mockedListServices = listOf(
    ServiceUI(
        id = "0",
        title = "Instalação de Rede",
        value = 180.0,
        isActive = true
    ),
    ServiceUI(
        id = "2",
        title = "Recuperação de Dados",
        value = 200.0,
        isActive = false
    ),
    ServiceUI(
        id = "3",
        title = "Manutenção de Hardware",
        value = 300.0,
        isActive = true

    )
)