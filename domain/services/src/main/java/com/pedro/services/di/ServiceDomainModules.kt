package com.pedro.services.di

import com.pedro.services.usecases.GetAllServicesUseCase
import com.pedro.services.usecases.SaveServiceUseCase
import com.pedro.services.usecases.UpdateServiceUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideServiceDomainModules(): List<Module> = listOf(
    module {
        factory { GetAllServicesUseCase(get()) }
        factory { SaveServiceUseCase(get()) }
        factory { UpdateServiceUseCase(get()) }
    }
)