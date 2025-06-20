package com.pedro.plataformachamados.di

import com.google.firebase.auth.FirebaseAuth
import com.pedro.plataformachamados.repositories.AuthFirebaseRepository
import com.pedro.plataformachamados.repositories.AuthFirebaseRepositoryImpl
import com.pedro.plataformachamados.ui.screens.login.LoginViewModel
import com.pedro.plataformachamados.ui.screens.register.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val viewModelModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::RegisterViewModel)
}

val firebaseModule = module {
    single<FirebaseAuth> { FirebaseAuth.getInstance() }
}

val repositoriesModule = module {
    single<AuthFirebaseRepository> {
        AuthFirebaseRepositoryImpl(get())
    }
}