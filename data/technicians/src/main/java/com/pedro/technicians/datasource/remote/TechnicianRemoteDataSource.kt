package com.pedro.technicians.datasource.remote

import com.pedro.technicians.model.remote.TechnicianRemote

interface TechnicianRemoteDataSource {
    suspend fun getAllTechnicians(): List<TechnicianRemote>
}