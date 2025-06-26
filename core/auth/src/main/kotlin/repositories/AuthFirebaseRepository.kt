package repositories

interface AuthFirebaseRepository {
    fun isLoggedIn(): Boolean
    suspend fun register(email: String, password: String): Boolean
    suspend fun login(email: String, password: String): Boolean
    fun logout()
}
