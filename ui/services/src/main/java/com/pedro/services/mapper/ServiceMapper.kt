package com.pedro.services.mapper

import com.pedro.services.model.ServiceDomain
import com.pedro.services.model.ServiceUI

fun ServiceDomain.toUI(): ServiceUI =
    ServiceUI(
        id = this.id,
        title = this.serviceName,
        value = this.serviceValue,
        isActive = this.isActivity
    )

fun ServiceUI.toDomain(): ServiceDomain =
    ServiceDomain(
        id = this.id,
        serviceName = this.title,
        serviceValue = this.value,
        isActivity = this.isActive
    )