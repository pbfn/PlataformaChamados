package com.pedro.network.di

import com.google.firebase.firestore.FirebaseFirestore
import com.pedro.network.FireStoreProvider
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideNetworkModules(): List<Module> = listOf(
    module {
        single { FirebaseFirestore.getInstance() }
        single { FireStoreProvider(get()) }
    },
)