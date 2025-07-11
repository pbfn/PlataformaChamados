package com.pedro.technicians.datasource.remote

import com.pedro.network.FireStoreProvider
import com.pedro.network.service.TechnicianApiService
import com.pedro.network.service.TechnicianDTO
import com.pedro.technicians.model.remote.TechnicianRemote

class TechnicianRemoteDataSourceImpl(
    private val fireStoreProvider: FireStoreProvider,
    private val technicianApiService: TechnicianApiService
) : TechnicianRemoteDataSource {

    override suspend fun getAllTechnicians(): List<TechnicianRemote> {
        return fireStoreProvider.getAllTechnicians().map {
            TechnicianRemote(
                id = it.id,
                name = it.name,
                email = it.email,
                password = "",
                availabilities = it.availabilities
            )
        }
    }

    override suspend fun saveTechnician(technicianRemote: TechnicianRemote) {
        technicianApiService.saveTechnician(
            TechnicianDTO(
                name = technicianRemote.name,
                email = technicianRemote.email,
                password = technicianRemote.password,
                role = "TECHNICIAN",
                availabilities = technicianRemote.availabilities
            )
        )
    }

}