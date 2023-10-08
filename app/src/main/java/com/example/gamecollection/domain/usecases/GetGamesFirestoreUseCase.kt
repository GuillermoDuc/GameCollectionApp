package com.example.gamecollection.domain.usecases

import android.util.Log
import com.example.gamecollection.utils.Constants
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class GetGamesFirestoreUseCase @Inject constructor(private val firebaseFirestore: FirebaseFirestore) {
    suspend fun getGames(email:String): MutableMap<String, Any>? {
        val docRef=firebaseFirestore.collection(Constants.FIRESTORE_USER_COLLECTION).document(email)
        return docRef.get().await().data
    }
}