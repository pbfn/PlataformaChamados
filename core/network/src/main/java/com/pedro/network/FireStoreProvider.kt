package com.pedro.network

import com.google.firebase.firestore.FirebaseFirestore
import com.pedro.network.model.TechnicianFireStore
import kotlinx.coroutines.tasks.await

class FireStoreProvider(
    private val firestore: FirebaseFirestore
) {

    suspend fun getAllTechnicians(): List<TechnicianFireStore> {
        val snapshot = firestore
            .collection("users")
            .whereEqualTo("role", "TECHNICIAN")
            .get()
            .await()

        return snapshot.documents.mapNotNull { doc ->
            doc.toObject(TechnicianFireStore::class.java)?.copy(id = doc.id)
        }
    }

    suspend fun getTechnicianById(id: String):TechnicianFireStore? {
        val snapshot = firestore
            .collection("users")
            .document(id)
            .get()
            .await()

        return snapshot.toObject(TechnicianFireStore::class.java)?.copy(id = snapshot.id)

    }
}