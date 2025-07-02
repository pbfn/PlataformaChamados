package com.pedro.technicians

import com.pedro.technicians.model.Technician
import com.pedro.technicians.repositories.TechnicianRepository
import kotlinx.coroutines.flow.Flow

class GetAllTechniciansUseCase(
    private val technicianRepository: TechnicianRepository
) {

    operator fun invoke(): Flow<List<Technician>> =
        technicianRepository.loadAllTechnicians()

}