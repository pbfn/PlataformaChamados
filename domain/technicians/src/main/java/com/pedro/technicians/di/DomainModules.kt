package com.pedro.technicians.di

import com.pedro.technicians.GetAllTechniciansUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideDomainModules(): List<Module> = listOf(
    module {
        factory { GetAllTechniciansUseCase(get()) }
    },
    provideDataModules()
)