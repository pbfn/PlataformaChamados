package com.pedro.technicians.repository

import com.pedro.technicians.model.TechnicianDomain
import kotlinx.coroutines.flow.Flow

interface TechnicianRepository {

    fun loadAllTechnicians(): Flow<List<TechnicianDomain>>

    fun loadTechnicianById(id: String): Flow<TechnicianDomain?>

    suspend fun saveTechnician(technicianDomain: TechnicianDomain)
}