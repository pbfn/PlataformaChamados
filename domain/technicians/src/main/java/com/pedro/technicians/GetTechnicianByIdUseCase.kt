package com.pedro.technicians

import com.pedro.technicians.model.TechnicianDomain
import com.pedro.technicians.repository.TechnicianRepository
import kotlinx.coroutines.flow.Flow

class GetTechnicianByIdUseCase(
    private val technicianRepository: TechnicianRepository
) {

    operator fun invoke(id: String): Flow<TechnicianDomain?> =
        technicianRepository.loadTechnicianById(id)
}