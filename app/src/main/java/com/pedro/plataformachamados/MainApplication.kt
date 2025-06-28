package com.pedro.plataformachamados

import android.app.Application
import com.google.firebase.FirebaseApp
import com.pedro.plataformachamados.di.viewModelModule
import di.provideFirebaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@MainApplication)
            modules(
                provideFirebaseModule(),
                viewModelModule,
            )
        }
    }

}