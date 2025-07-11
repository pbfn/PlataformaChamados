package com.pedro.technicians.di

import com.pedro.technicians.GetAllTechniciansUseCase
import com.pedro.technicians.GetTechnicianByIdUseCase
import com.pedro.technicians.SaveTechnicianUseCase
import com.pedro.technicians.UpdateTechnicianUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideDomainModules(): List<Module> = listOf(
    module {
        factory { GetAllTechniciansUseCase(get()) }
        factory { GetTechnicianByIdUseCase(get()) }
        factory { SaveTechnicianUseCase(get()) }
        factory { UpdateTechnicianUseCase(get()) }
    },
)