package com.pedro.plataformachamados.data.global_state

import kotlinx.coroutines.flow.StateFlow

interface UserStateHolder {
    val userState: StateFlow<UserState>
    fun updateUserState()
    fun clearUser()
}