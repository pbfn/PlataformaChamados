package com.pedro.network

import com.google.firebase.firestore.FirebaseFirestore
import com.pedro.network.model.ServiceResponseFireStore
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

    suspend fun getAllServices(): List<ServiceResponseFireStore> {
        val snapshot = firestore
            .collection("services")
            .get()
            .await()

        return snapshot.documents.mapNotNull { doc ->
            val base = doc.toObject(ServiceResponseFireStore::class.java)
            val isActivity = doc.getBoolean("isActivity") ?: false
            base?.copy(
                id = doc.id,
                isActivity = isActivity
            )
        }
    }

    suspend fun saveService(service: ServiceResponseFireStore) {
        val serviceMap = hashMapOf(
            "serviceName" to service.serviceName,
            "serviceValue" to service.serviceValue,
            "isActivity" to service.isActivity
        )

        firestore.collection("services")
            .add(serviceMap)
            .await()
    }

    suspend fun updateService(service: ServiceResponseFireStore) {
        val serviceMap = hashMapOf(
            "serviceName" to service.serviceName,
            "serviceValue" to service.serviceValue,
            "isActivity" to service.isActivity
        )

        firestore.collection("services")
            .document(service.id)
            .set(serviceMap)
            .await()
    }
}