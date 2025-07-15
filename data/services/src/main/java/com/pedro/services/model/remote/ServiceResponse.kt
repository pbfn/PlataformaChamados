package com.pedro.services.model.remote

data class ServiceResponse(
    val id: String,
    val serviceName: String,
    val serviceValue: Double,
    val isActivity: Boolean
)