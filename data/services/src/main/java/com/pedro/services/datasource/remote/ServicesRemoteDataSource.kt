package com.pedro.services.datasource.remote

import com.pedro.services.model.remote.ServiceResponse

interface ServicesRemoteDataSource {

    suspend fun getAllServices(): List<ServiceResponse>

    suspend fun saveService(service: ServiceResponse)

    suspend fun updateService(service: ServiceResponse)

}