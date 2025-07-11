package com.pedro.technicians.mapper

import com.pedro.technicians.model.TechnicianDomain
import com.pedro.technicians.model.TechnicianUI

fun TechnicianDomain.toUI(): TechnicianUI =
    TechnicianUI(
        id = this.id,
        name = this.name,
        email = this.email,
        password = this.password,
        morningAvailabilities = this.morningAvailabilities,
        afternoonAvailabilities = this.afternoonAvailabilities,
        nightAvailabilities = this.nightAvailabilities,
    )