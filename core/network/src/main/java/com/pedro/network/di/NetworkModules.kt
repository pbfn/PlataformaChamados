package com.pedro.network.di

import com.google.firebase.firestore.FirebaseFirestore
import com.pedro.network.FireStoreProvider
import com.pedro.network.service.TechnicianApiService
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging

private const val NETWORK_TIMEOUT = 5_000L

fun provideNetworkModules(): List<Module> = listOf(
    module {
        single<HttpClient> { provideKtorClient() }
        single { TechnicianApiService(get()) }
        single { FirebaseFirestore.getInstance() }
        single { FireStoreProvider(get()) }
    },
)

private fun provideKtorClient(): HttpClient {

    val httpClientAndroid by lazy {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        useAlternativeNames = true
                        ignoreUnknownKeys = true
                        explicitNulls = true
                        useArrayPolymorphism = true
                        encodeDefaults = false
                    }
                )
            }

            install(HttpTimeout) {
                requestTimeoutMillis = NETWORK_TIMEOUT
                connectTimeoutMillis = NETWORK_TIMEOUT
                socketTimeoutMillis = NETWORK_TIMEOUT
            }

            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }
    return httpClientAndroid
}