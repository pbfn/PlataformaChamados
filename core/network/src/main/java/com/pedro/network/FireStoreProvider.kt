package com.pedro.network

import com.google.firebase.firestore.FirebaseFirestore
import com.pedro.network.model.TechnicianFireStore
import kotlinx.coroutines.tasks.await

class FireStoreProvider(
    private val firestore: FirebaseFirestore
) {

    suspend fun getAllTechnicians(): List<TechnicianFireStore> {
        val snapshot = firestore
            .collection("technicians")
            .get()
            .await()

        return snapshot.documents.mapNotNull { it.toObject(TechnicianFireStore::class.java) }
    }
}