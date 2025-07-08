package com.pedro.technicians

import com.pedro.technicians.model.TechnicianDomain
import com.pedro.technicians.repository.TechnicianRepository

class SaveTechnicianUseCase(
    private val technicianRepository: TechnicianRepository
) {

    suspend operator fun invoke(technicianDomain: TechnicianDomain) {
        technicianRepository.saveTechnician(technicianDomain)
    }
}