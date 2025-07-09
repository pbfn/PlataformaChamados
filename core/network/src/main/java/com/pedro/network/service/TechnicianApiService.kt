package com.pedro.network.service

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.Serializable

class TechnicianApiService(private val client: HttpClient) {

    private val LOCAL_HOST_EMULATOR_BASE_URL = "http://10.0.2.2:8080"
    private val LOCAL_HOST_PHYSICAL_BASE_URL = "http://192.168.0.109:8080"
    private val BASE_URL = LOCAL_HOST_PHYSICAL_BASE_URL


    suspend fun saveTechnician(technicianDTO: TechnicianDTO) {
        client.post("$LOCAL_HOST_PHYSICAL_BASE_URL/api/users") {
            contentType(ContentType.Application.Json)
            setBody(technicianDTO)
        }
    }
}

@Serializable
data class TechnicianDTO(
    val nome: String,
    val login: String,
    val senha: String,
    val role: String
)