package com.pedro.technicians.di

import com.pedro.technicians.viewmodel.ListTechniciansViewModel
import com.pedro.technicians.viewmodel.ProfileScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

private val techniciansModules = module {
    viewModelOf(::ProfileScreenViewModel)
    viewModelOf(::ListTechniciansViewModel)
}

fun provideTechniciansModules() = techniciansModules