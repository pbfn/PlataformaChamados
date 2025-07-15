package com.pedro.services.repository

import com.pedro.services.model.ServiceDomain
import kotlinx.coroutines.flow.Flow

interface ServiceRepository {

    fun loadAllServices(): Flow<List<ServiceDomain>>

    suspend fun saveService(service: ServiceDomain)

    suspend fun updateService(service: ServiceDomain)

}