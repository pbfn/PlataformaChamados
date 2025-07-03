package com.pedro.technicians.repositories

import com.pedro.technicians.datasource.local.TechnicianLocalDataSource
import com.pedro.technicians.datasource.remote.TechnicianRemoteDataSource
import com.pedro.technicians.model.Technician
import com.pedro.technicians.model.TechnicianDomain
import com.pedro.technicians.repository.TechnicianRepository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TechnicianRepositoryImpl(
    private val localDataSource: TechnicianLocalDataSource,
    private val remoteDataSource: TechnicianRemoteDataSource
) : TechnicianRepository {

    private val mockedList = listOf(
        Technician(
            id = 1,
            name = "Pedro Bruno",
            email = "pedro@gmail.com",
            availabilities = listOf("08:00", "10:00", "13:00", "15:00")
        ),
        Technician(
            id = 2,
            name = "Rebeca Nantes",
            email = "rebeca@gmail.com",
            availabilities = listOf(
                "10:00",
                "11:00",
                "13:00",
                "15:00",
                "18:00",
                "21:00",
                "22:00"
            )
        ),
        Technician(
            id = 3,
            name = "João Paulo",
            email = "joao@gmail.com",
            availabilities = listOf("15:00", "18:00", "21:00", "22:00")
        ),
        Technician(
            email = "ricardo@gmail.com",
            id = 4,
            name = "Ricardo",
            availabilities = listOf("16:00")
        ),
    )

    override fun loadAllTechnicians(): Flow<List<TechnicianDomain>> = flow {
        delay(5000L)
        emit(
            mockedList.map { it.toDomain() }
        )
    }

    override fun loadTechnicianById(id: Int): Flow<TechnicianDomain?> = flow {
        delay(2000L)
        emit(
            mockedList.find { it.id == id }?.toDomain()
        )
    }
}


fun Technician.toDomain(): TechnicianDomain {
    return TechnicianDomain(
        id = id,
        name = name,
        email = email,
        availabilities = availabilities
    )
}