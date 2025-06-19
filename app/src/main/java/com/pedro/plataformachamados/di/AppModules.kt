package com.pedro.plataformachamados.di

import com.pedro.plataformachamados.ui.screens.login.LoginViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val viewModelModule = module {
    viewModelOf(::LoginViewModel)
}