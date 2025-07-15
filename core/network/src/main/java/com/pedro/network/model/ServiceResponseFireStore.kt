package com.pedro.network.model

data class ServiceResponseFireStore(
    var id: String = "",
    var serviceName: String = "",
    var serviceValue: Double = 0.0,
    var isActivity: Boolean = false
)
