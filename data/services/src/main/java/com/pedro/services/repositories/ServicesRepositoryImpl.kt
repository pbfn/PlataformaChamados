package com.pedro.services.repositories

import com.pedro.services.datasource.remote.ServicesRemoteDataSource
import com.pedro.services.model.ServiceDomain
import com.pedro.services.model.remote.ServiceResponse
import com.pedro.services.repository.ServiceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ServicesRepositoryImpl(
    private val remoteDataSource: ServicesRemoteDataSource
) : ServiceRepository {

    override fun loadAllServices(): Flow<List<ServiceDomain>> = flow {
        emit(remoteDataSource.getAllServices().map {
            ServiceDomain(
                id = it.id,
                serviceName = it.serviceName,
                serviceValue = it.serviceValue,
                isActivity = it.isActivity
            )
        })
    }

    override suspend fun saveService(service: ServiceDomain) {
        remoteDataSource.saveService(
            service = ServiceResponse(
                id = service.id,
                serviceName = service.serviceName,
                serviceValue = service.serviceValue,
                isActivity = service.isActivity
            )
        )
    }

    override suspend fun updateService(service: ServiceDomain) {
        remoteDataSource.updateService(
            service = ServiceResponse(
                id = service.id,
                serviceName = service.serviceName,
                serviceValue = service.serviceValue,
                isActivity = service.isActivity
            )
        )
    }
}