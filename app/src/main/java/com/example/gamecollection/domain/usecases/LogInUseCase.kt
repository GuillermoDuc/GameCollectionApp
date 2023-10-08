package com.example.gamecollection.domain.usecases

import com.example.gamecollection.network.LoginResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LogInUseCase @Inject constructor(private val firebaseAuth:FirebaseAuth){

    private suspend fun logInFireBase(email:String, password: String):Boolean {
        return kotlin.runCatching {
            firebaseAuth.signInWithEmailAndPassword(email,password).await()
        }.isSuccess
    }
    suspend  fun LogIn (email:String,password:String): LoginResult? {
        return if(logInFireBase(email,password))
            LoginResult.Success
        else LoginResult.Error
    }
}