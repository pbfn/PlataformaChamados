package com.pedro.technicians.di

import com.pedro.technicians.datasource.local.TechnicianLocalDataSource
import com.pedro.technicians.datasource.local.TechnicianLocalDataSourceImpl
import com.pedro.technicians.datasource.remote.TechnicianRemoteDataSource
import com.pedro.technicians.datasource.remote.TechnicianRemoteDataSourceImpl
import com.pedro.technicians.repositories.TechnicianRepository
import com.pedro.technicians.repositories.TechnicianRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideDataModules(): Module = module {
    single<TechnicianLocalDataSource> { TechnicianLocalDataSourceImpl() }
    single<TechnicianRemoteDataSource> { TechnicianRemoteDataSourceImpl() }
    single<TechnicianRepository> { TechnicianRepositoryImpl(get(), get()) }
}