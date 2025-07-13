package com.pedro.services.di

import com.pedro.services.viewmodel.ListServicesViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun provideServicesModules(): List<Module> = listOf(
    module {
        viewModelOf(::ListServicesViewModel)
    },

    )