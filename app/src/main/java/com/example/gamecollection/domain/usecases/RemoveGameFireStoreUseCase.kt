package com.example.gamecollection.domain.usecases

import com.example.gamecollection.utils.Constants
import com.example.gamecollection.utils.Constants.FIRESTORE_USER_GAME_DIRECTORY
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class RemoveGameFireStoreUseCase @Inject constructor (private val firebaseFirestore: FirebaseFirestore){
    fun invoke(gameSlug:String,email:String) {
        val docRef=firebaseFirestore.collection(Constants.FIRESTORE_USER_COLLECTION).document(email)
        docRef.update(FIRESTORE_USER_GAME_DIRECTORY, FieldValue.arrayRemove(gameSlug))
    }
}