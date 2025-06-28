package provider

import android.content.Context
import com.google.firebase.FirebaseApp

internal class FirebaseManagerImpl : FirebaseManager {
    override fun init(context: Context) {
        FirebaseApp.initializeApp(context)
    }
}