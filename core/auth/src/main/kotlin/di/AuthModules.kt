package di

import com.google.firebase.auth.FirebaseAuth
import org.koin.dsl.module
import repositories.AuthFirebaseRepository
import repositories.AuthFirebaseRepositoryImpl

private val firebaseModule = module {
    single<FirebaseAuth> { FirebaseAuth.getInstance() }
    single<AuthFirebaseRepository> {
        AuthFirebaseRepositoryImpl(get(), get())
    }
}

fun provideFirebaseModule() = firebaseModule