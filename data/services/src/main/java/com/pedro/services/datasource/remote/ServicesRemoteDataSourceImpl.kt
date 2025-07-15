package com.pedro.services.datasource.remote

import com.pedro.network.FireStoreProvider
import com.pedro.network.model.ServiceResponseFireStore
import com.pedro.services.model.remote.ServiceResponse

class ServicesRemoteDataSourceImpl(
    private val fireStoreProvider: FireStoreProvider
) : ServicesRemoteDataSource {

    override suspend fun getAllServices(): List<ServiceResponse> {
        return fireStoreProvider.getAllServices().map {
            ServiceResponse(
                id = it.id,
                serviceName = it.serviceName,
                serviceValue = it.serviceValue,
                isActivity = it.isActivity
            )
        }
    }

    override suspend fun saveService(service: ServiceResponse) {
        fireStoreProvider.saveService(
            service = ServiceResponseFireStore(
                serviceName = service.serviceName,
                serviceValue = service.serviceValue,
                isActivity = service.isActivity
            )
        )
    }

    override suspend fun updateService(service: ServiceResponse) {
        fireStoreProvider.updateService(
            service = ServiceResponseFireStore(
                id = service.id,
                serviceName = service.serviceName,
                serviceValue = service.serviceValue,
                isActivity = service.isActivity
            )
        )
    }
}