package com.pedro.technicians

import com.pedro.technicians.model.TechnicianDomain
import com.pedro.technicians.repository.TechnicianRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllTechniciansUseCase(
    private val technicianRepository: TechnicianRepository
) {

    operator fun invoke(): Flow<List<TechnicianDomain>> =
        technicianRepository.loadAllTechnicians()
}