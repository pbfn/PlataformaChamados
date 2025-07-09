package com.pedro.technicians.di

import com.pedro.network.di.provideNetworkModules
import com.pedro.technicians.datasource.local.TechnicianLocalDataSource
import com.pedro.technicians.datasource.local.TechnicianLocalDataSourceImpl
import com.pedro.technicians.datasource.remote.TechnicianRemoteDataSource
import com.pedro.technicians.datasource.remote.TechnicianRemoteDataSourceImpl
import com.pedro.technicians.repositories.TechnicianRepositoryImpl
import com.pedro.technicians.repository.TechnicianRepository
import org.koin.core.module.Module
import org.koin.dsl.module
import kotlin.collections.List

fun provideDataModules(): List<Module> = listOf(
    module {
        single<TechnicianLocalDataSource> { TechnicianLocalDataSourceImpl() }
        single<TechnicianRemoteDataSource> { TechnicianRemoteDataSourceImpl(get(),get()) }
        single<TechnicianRepository> { TechnicianRepositoryImpl(get(), get()) }
    },
    *provideNetworkModules().toTypedArray()
)
