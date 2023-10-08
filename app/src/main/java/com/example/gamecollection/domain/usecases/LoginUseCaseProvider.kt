package com.example.gamecollection.domain.usecases

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
class LoginUseCaseProvider {
    @Provides
    fun provideLoginUseCase(firebaseAuth: FirebaseAuth): LogInUseCase {
        return LogInUseCase(firebaseAuth)
    }
}