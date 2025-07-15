package com.pedro.services.di

import com.pedro.services.datasource.remote.ServicesRemoteDataSource
import com.pedro.services.datasource.remote.ServicesRemoteDataSourceImpl
import com.pedro.services.repositories.ServicesRepositoryImpl
import com.pedro.services.repository.ServiceRepository
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideServicesDataModule(): List<Module> =  listOf(
    module {
        single<ServiceRepository> { ServicesRepositoryImpl(get()) }
        single<ServicesRemoteDataSource> { ServicesRemoteDataSourceImpl(get()) }

    }
)