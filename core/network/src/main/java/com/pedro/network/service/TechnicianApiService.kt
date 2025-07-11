package com.pedro.network.service

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import kotlinx.serialization.Serializable

private const val LOCAL_HOST_EMULATOR_BASE_URL = "http://10.0.2.2:8080"
private const val LOCAL_HOST_PHYSICAL_BASE_URL = "http://192.168.0.109:8080"
private const val BASE_URL = LOCAL_HOST_PHYSICAL_BASE_URL


class TechnicianApiService(private val client: HttpClient) {

    suspend fun saveTechnician(technicianDTO: TechnicianDTO) {
        client.post("$BASE_URL/api/users") {
            contentType(ContentType.Application.Json)
            setBody(technicianDTO)
        }
    }

    suspend fun updateTechnician(id: String,technicianUpdateDTO: TechnicianUpdateDTO) : Boolean {
        return try {
            val response = client.put("$BASE_URL/api/users/$id") {
                contentType(ContentType.Application.Json)
                setBody(technicianUpdateDTO)
            }
            response.status.isSuccess()
        } catch (e: Exception) {
            Log.e("Ktor", "Erro ao atualizar usuário", e)
            false
        }
    }
}

@Serializable
data class TechnicianDTO(
    val name: String,
    val email: String,
    val password: String,
    val role: String,
    val availabilities: List<String>
)

@Serializable
data class TechnicianUpdateDTO(
    val name: String,
    val email: String,
    val availabilities: List<String>
)