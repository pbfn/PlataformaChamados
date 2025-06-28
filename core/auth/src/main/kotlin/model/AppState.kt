package model

data class AppState(
    val user: User? = null,
    val isInitLoading: Boolean = true
)