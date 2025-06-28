package com.pedro.plataformachamados

import android.app.Application
import com.google.firebase.FirebaseApp
import com.pedro.plataformachamados.di.viewModelModule
import di.provideFirebaseModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import provider.FirebaseManager

class MainApplication : Application() {


    //private val firebaseManager by inject<FirebaseManager>()

    override fun onCreate() {
        super.onCreate()

        //FirebaseApp.initializeApp(this)

       // firebaseManager.init(this)

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