package di

import com.google.firebase.auth.FirebaseAuth
import data.global_state.AppViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import repositories.AuthFirebaseRepository
import repositories.AuthFirebaseRepositoryImpl

private val firebaseModule = module {
    single<FirebaseAuth> { FirebaseAuth.getInstance() }
    single<AuthFirebaseRepository> {
        AuthFirebaseRepositoryImpl(get())
    }
    viewModelOf(::AppViewModel)
}

fun provideFirebaseModule() = firebaseModule