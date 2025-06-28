package model

import com.google.firebase.auth.FirebaseUser

data class AuthResult(
    val currentUser: FirebaseUser? = null,
    val isInitLoading: Boolean = true
)