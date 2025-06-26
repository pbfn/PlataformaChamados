package com.pedro.plataformachamados.di


import com.pedro.plataformachamados.ui.screens.admin.home.HomeViewModel
import com.pedro.plataformachamados.ui.screens.login.LoginViewModel
import com.pedro.plataformachamados.ui.screens.register.RegisterViewModel
import com.pedro.plataformachamados.ui.screens.splash.SplashViewModel
import data.global_state.UserStateHolder
import data.global_state.UserStateHolderImpl
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val viewModelModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::RegisterViewModel)
    viewModelOf(::SplashViewModel)
    viewModelOf(::HomeViewModel)
}


val appModule = module {
    single<UserStateHolder> { UserStateHolderImpl() }
}