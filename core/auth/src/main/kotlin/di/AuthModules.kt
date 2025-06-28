package di

import com.google.firebase.auth.FirebaseAuth
import data.global_state.AppViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import provider.FirebaseManagerImpl
import repositories.AuthFirebaseRepository
import repositories.AuthFirebaseRepositoryImpl

private val firebaseModule = module {
    single<FirebaseAuth> { FirebaseAuth.getInstance() }
    single<AuthFirebaseRepository> {
        AuthFirebaseRepositoryImpl(get())
    }
    singleOf(::FirebaseManagerImpl) { bind<FirebaseManagerImpl>() }
    viewModelOf(::AppViewModel)
}

fun provideFirebaseModule() = firebaseModule