package com.example.gamecollection.domain.usecases

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
class GetGamesFirestoreUseCaseProvider () {
    @Provides
    fun provideGetGamesFirestoreUseCase(firebaseFirestore: FirebaseFirestore):GetGamesFirestoreUseCase{
        return GetGamesFirestoreUseCase(firebaseFirestore)
    }
}