package data.global_state

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class UserStateHolderImpl : UserStateHolder {

    private val _userState = MutableStateFlow(UserState())
    override val userState: StateFlow<UserState> = _userState

    override fun updateUserState() {
        _userState.update { current ->
            current.copy(isLoggedIn = true)
        }
    }

    override fun clearUser() {
        _userState.update { UserState() }
    }
}