package com.pedro.services.usecases

import com.pedro.services.model.ServiceDomain
import com.pedro.services.repository.ServiceRepository

class SaveServiceUseCase(
    private val servicesRepository: ServiceRepository
) {

    suspend operator fun invoke(serviceDomain: ServiceDomain) {
        servicesRepository.saveService(serviceDomain)
    }

}