package com.pedro.services.usecases

import com.pedro.services.model.ServiceDomain
import com.pedro.services.repository.ServiceRepository
import kotlinx.coroutines.flow.Flow

class GetAllServicesUseCase(
    private val servicesRepository: ServiceRepository
) {

    operator fun invoke(): Flow<List<ServiceDomain>> =
        servicesRepository.loadAllServices()
}