package com.pedro.technicians.mapper

import com.pedro.technicians.model.TechnicianDomain
import com.pedro.technicians.model.TechnicianUI

fun TechnicianDomain.toUI(): TechnicianUI =
    TechnicianUI(
        id = this.id,
        name = this.name,
        email = this.email,
        availabilities = this.availabilities
    )