package com.example.gamecollection.domain.usecases

import android.util.Patterns
import androidx.navigation.NavController
import com.example.gamecollection.network.LoginResult
import com.example.gamecollection.ui.navigation.ScreenPaths
import com.example.gamecollection.utils.Constants
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class SignUpUseCase @Inject constructor(private val firebaseAuth: FirebaseAuth
                                        ,private val fireStore: FirebaseFirestore
){
    suspend fun signUpUseCase(email:String,password:String):LoginResult{
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()&&password.length>6){
            if(createAccount(email,password)!=null){
                if(createUserDocument(email)){
                    return LoginResult.Success
                }
            }
        }
        return LoginResult.Error
    }
    suspend fun createUserDocument(email:String): Boolean {
        return kotlin.runCatching {
            val gamesId: List<Int> = emptyList()

            fireStore.collection(Constants.FIRESTORE_USER_COLLECTION)
                .document(email)
                .set(hashMapOf("games" to gamesId))
                .await()
        }.isSuccess
    }

    suspend fun createAccount(email:String,password:String): AuthResult? {
        return firebaseAuth.createUserWithEmailAndPassword(email,password).await()
    }
}