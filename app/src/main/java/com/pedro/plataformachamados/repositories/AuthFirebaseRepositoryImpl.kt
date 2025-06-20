package com.pedro.plataformachamados.repositories

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AuthFirebaseRepositoryImpl(
    private val firebaseAuth: FirebaseAuth
): AuthFirebaseRepository {

    private val tag = "AuthFirebaseRepository"

    override fun isLoggedIn(): Boolean {
        return if (firebaseAuth.currentUser != null) {
            println(tag + "Already logged")
            true
        } else false
    }

    override suspend fun register(email: String, password: String): Boolean {
        try {
            val result = suspendCoroutine { continuation ->
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener {
                        println("$tag register success")
                        CoroutineScope(Dispatchers.IO).launch {
                            continuation.resume(login(email, password))
                        }
                    }
                    .addOnFailureListener {
                        println("$tag register failure")
                        continuation.resume(false)
                    }
            }

            return result
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            println(tag + " register exception ${e.message}")
            return false
        }
    }

    override suspend fun login(email: String, password: String): Boolean {
        try {
            val result = suspendCoroutine { continuation ->
                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener {
                        println("$tag login success")
                        continuation.resume(true)
                    }
                    .addOnFailureListener {
                        println("$tag login failure")
                        continuation.resume(false)
                    }
            }
            return result
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            println(tag + "login exception ${e.message}")
            return false
        }
    }

    override fun logout(){
        firebaseAuth.signOut()
    }

}