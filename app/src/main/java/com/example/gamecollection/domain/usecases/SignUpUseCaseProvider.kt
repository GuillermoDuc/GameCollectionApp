package com.example.gamecollection.domain.usecases

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class SignUpUseCaseProvider {
    @Provides
    fun provideSignUpUseCase(firebaseAuth: FirebaseAuth, firebaseFirestore: FirebaseFirestore): SignUpUseCase {
        return SignUpUseCase(firebaseAuth,firebaseFirestore)
    }
}