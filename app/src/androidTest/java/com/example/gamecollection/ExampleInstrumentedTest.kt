package com.example.gamecollection

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.gamecollection.domain.usecases.GetGameApiUseCase
import com.example.gamecollection.domain.usecases.GetGamesFirestoreUseCase
import com.example.gamecollection.domain.usecases.LogInUseCase
import com.example.gamecollection.domain.usecases.SignUpUseCase
import com.example.gamecollection.network.Retrofit
import com.example.gamecollection.ui.screens.login.LoginScreen
import com.example.gamecollection.ui.screens.login.LoginViewModel
import com.example.gamecollection.ui.screens.profile_view.ProfileScreen
import com.example.gamecollection.ui.screens.profile_view.ProfileScreenViewModel
import com.example.gamecollection.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import okhttp3.OkHttpClient

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
@get:Rule
val rule= createComposeRule()
    @Test
    fun testLogInScreen(){
        rule.setContent {
            val firebaseAuth= FirebaseAuth.getInstance()
            val loginUseCase= LogInUseCase(firebaseAuth)
            val signUpUseCase= SignUpUseCase(firebaseAuth,FirebaseFirestore.getInstance())
            val vm=LoginViewModel(loginUseCase,signUpUseCase,firebaseAuth)
            LoginScreen(viewModel = vm, navController = rememberNavController())
        }
        rule.onNodeWithText("Email").performClick()
        rule.onNodeWithText("Email").performTextInput("test@test.com")
        rule.onNodeWithText("Password").performClick()
        rule.onNodeWithText("Password").performTextInput("Password")
        rule.onNodeWithText("test@test.com").assertTextEquals("test@test.com")
        rule.onNodeWithText("Log In").performClick()
    }
    fun provideRetrofit(): retrofit2.Retrofit {
        val okHttpClient= OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
        return retrofit2.Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    }
    @Test
    fun testProfileScreen(){
        rule.setContent {
            val fireStore= FirebaseFirestore.getInstance()
            val getApiUseCase= GetGameApiUseCase(provideRetrofit())
            val getGamesFirestoreUseCase= GetGamesFirestoreUseCase(fireStore)
            val vm= ProfileScreenViewModel(getGamesFirestoreUseCase,getApiUseCase)
            ProfileScreen(viewModel = vm, navController = rememberNavController(), email = "exalyno123@gmail.com")
        }
    }
}