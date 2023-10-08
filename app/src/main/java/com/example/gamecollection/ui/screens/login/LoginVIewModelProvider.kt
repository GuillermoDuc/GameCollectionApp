package com.example.gamecollection.ui.screens.login

import com.example.gamecollection.domain.usecases.LogInUseCase
import com.example.gamecollection.domain.usecases.SignUpUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class LoginVIewModelProvider {
    @Provides
    fun provideLoginViewModel(logInUseCase: LogInUseCase, signUpUseCase: SignUpUseCase,firebaseAuth: FirebaseAuth): LoginViewModel {
        return LoginViewModel(logInUseCase,signUpUseCase,firebaseAuth)
    }
}