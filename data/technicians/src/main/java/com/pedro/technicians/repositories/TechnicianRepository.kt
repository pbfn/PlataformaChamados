package com.pedro.technicians.repositories

import com.pedro.technicians.model.Technician
import kotlinx.coroutines.flow.Flow

interface TechnicianRepository {

    fun loadAllTechnicians(): Flow<List<Technician>>

    fun loadTechnicianById(id: Int): Flow<Technician?>
}