package com.pedro.plataformachamados.di

import com.google.firebase.auth.FirebaseAuth
import com.pedro.plataformachamados.data.global_state.UserStateHolder
import com.pedro.plataformachamados.data.global_state.UserStateHolderImpl
import com.pedro.plataformachamados.repositories.AuthFirebaseRepository
import com.pedro.plataformachamados.repositories.AuthFirebaseRepositoryImpl
import com.pedro.plataformachamados.ui.screens.admin.home.HomeViewModel
import com.pedro.plataformachamados.ui.screens.login.LoginViewModel
import com.pedro.plataformachamados.ui.screens.register.RegisterViewModel
import com.pedro.plataformachamados.ui.screens.splash.SplashViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val viewModelModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::RegisterViewModel)
    viewModelOf(::SplashViewModel)
    viewModelOf(::HomeViewModel)
}

val firebaseModule = module {
    single<FirebaseAuth> { FirebaseAuth.getInstance() }
}

val repositoriesModule = module {
    single<AuthFirebaseRepository> {
        AuthFirebaseRepositoryImpl(get(), get())
    }
}

val appModule = module {
    single<UserStateHolder> { UserStateHolderImpl() }
}