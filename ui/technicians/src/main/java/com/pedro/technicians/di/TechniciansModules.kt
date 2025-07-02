package com.pedro.technicians.di

import com.pedro.technicians.viewmodel.ListTechniciansViewModel
import com.pedro.technicians.viewmodel.ProfileScreenViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun provideTechniciansModules(): List<Module> = listOf(
    module {
        viewModelOf(::ProfileScreenViewModel)
        viewModelOf(::ListTechniciansViewModel)
    },
    *provideDomainModules().toTypedArray()
)