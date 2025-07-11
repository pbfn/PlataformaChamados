package com.pedro.technicians.repositories

import com.pedro.technicians.datasource.local.TechnicianLocalDataSource
import com.pedro.technicians.datasource.remote.TechnicianRemoteDataSource
import com.pedro.technicians.model.HoursPeriod
import com.pedro.technicians.model.Technician
import com.pedro.technicians.model.TechnicianDomain
import com.pedro.technicians.model.filterByPeriod
import com.pedro.technicians.model.remote.TechnicianRemote
import com.pedro.technicians.repository.TechnicianRepository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TechnicianRepositoryImpl(
    private val localDataSource: TechnicianLocalDataSource,
    private val remoteDataSource: TechnicianRemoteDataSource
) : TechnicianRepository {

    override fun loadAllTechnicians(): Flow<List<TechnicianDomain>> = flow {
        emit(
            remoteDataSource.getAllTechnicians().map {
                TechnicianDomain(
                    id = it.id,
                    name = it.name,
                    email = it.email,
                    password = it.password,
                    morningAvailabilities = it.availabilities.filterByPeriod(HoursPeriod.MORNING),
                    afternoonAvailabilities = it.availabilities.filterByPeriod(HoursPeriod.AFTERNOON),
                    nightAvailabilities = it.availabilities.filterByPeriod(HoursPeriod.NIGHT),
                )
            }
        )
    }

    override fun loadTechnicianById(id: String): Flow<TechnicianDomain?> = flow {
        val response = remoteDataSource.getTechnicianById(id)
        if (response != null) {
            emit(
                response.toDomain()
            )
        }
    }

    override suspend fun saveTechnician(technicianDomain: TechnicianDomain) {
        remoteDataSource.saveTechnician(
            TechnicianRemote(
                id = technicianDomain.id,
                name = technicianDomain.name,
                email = technicianDomain.email,
                password = technicianDomain.password,
                availabilities = technicianDomain.morningAvailabilities + technicianDomain.afternoonAvailabilities + technicianDomain.nightAvailabilities,
            )
        )
    }

    override suspend fun updateTechnician(technicianDomain: TechnicianDomain) {
        remoteDataSource.updateTechnician(
            TechnicianRemote(
                id = technicianDomain.id,
                name = technicianDomain.name,
                email = technicianDomain.email,
                password = "",
                availabilities = technicianDomain.morningAvailabilities + technicianDomain.afternoonAvailabilities + technicianDomain.nightAvailabilities,
            )
        )
    }
}


fun Technician.toDomain(): TechnicianDomain {
    return TechnicianDomain(
        id = id,
        name = name,
        email = email,
        password = password,
        morningAvailabilities = availabilities.filterByPeriod(HoursPeriod.MORNING),
        afternoonAvailabilities = availabilities.filterByPeriod(HoursPeriod.AFTERNOON),
        nightAvailabilities = availabilities.filterByPeriod(HoursPeriod.NIGHT),
    )
}

fun TechnicianRemote.toDomain(): TechnicianDomain {
    return TechnicianDomain(
        id = id,
        name = name,
        email = email,
        password = password,
        morningAvailabilities = availabilities.filterByPeriod(HoursPeriod.MORNING),
        afternoonAvailabilities = availabilities.filterByPeriod(HoursPeriod.AFTERNOON),
        nightAvailabilities = availabilities.filterByPeriod(HoursPeriod.NIGHT),
    )
}