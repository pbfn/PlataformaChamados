package com.pedro.plataformachamados

import android.app.Application
import com.pedro.plataformachamados.di.appModule
import com.pedro.plataformachamados.di.firebaseModule
import com.pedro.plataformachamados.di.repositoriesModule
import com.pedro.plataformachamados.di.viewModelModule
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
                viewModelModule,
                firebaseModule,
                repositoriesModule,
                appModule
            )
        }
    }

}