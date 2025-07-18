package com.pedro.plataformachamados

import android.app.Application
import com.pedro.plataformachamados.di.viewModelModule
import com.pedro.services.di.provideServicesDataModule
import com.pedro.services.di.provideServicesModules
import com.pedro.technicians.di.provideDataModules
import com.pedro.technicians.di.provideTechniciansModules
import di.provideFirebaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@MainApplication)
            modules(
                provideFirebaseModule(),
                *provideDataModules().toTypedArray(),
                *provideServicesDataModule().toTypedArray(),
                *provideTechniciansModules().toTypedArray(),
                *provideServicesModules().toTypedArray(),
                viewModelModule,
            )
        }
    }

}