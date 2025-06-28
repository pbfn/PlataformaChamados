package data.global_state

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import model.AppState
import model.User
import repositories.AuthFirebaseRepository


class AppViewModel(
    private val authFirebaseRepository: AuthFirebaseRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AppState())
    val state = _state
        .combine(authFirebaseRepository.currentUser) { appState, authResult ->
            val user = authResult.currentUser?.email?.let { User(it) }
            appState.copy(user = user, isInitLoading = authResult.isInitLoading)
        }


}