package com.pedro.plataformachamados.di


import com.pedro.plataformachamados.ui.screens.admin.home.HomeViewModel
import com.pedro.plataformachamados.ui.screens.login.LoginViewModel
import com.pedro.plataformachamados.ui.screens.register.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val viewModelModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::RegisterViewModel)
    viewModelOf(::HomeViewModel)
}