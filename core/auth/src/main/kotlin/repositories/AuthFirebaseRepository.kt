package repositories

import kotlinx.coroutines.flow.StateFlow
import model.AuthResult

interface AuthFirebaseRepository {

    val currentUser: StateFlow<AuthResult>
    suspend fun register(email: String, password: String): Boolean
    suspend fun login(email: String, password: String): Boolean
    fun logout()
}
