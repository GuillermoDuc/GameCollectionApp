package com.example.gamecollection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamecollection.data.GameModel
import com.example.gamecollection.domain.usecases.GetGameApiUseCase
import com.example.gamecollection.domain.usecases.LogInUseCase
import com.example.gamecollection.network.ApiService
import com.example.gamecollection.ui.navigation.ScreenPaths
import com.example.gamecollection.ui.screens.game_details.DetailsScreen
import com.example.gamecollection.ui.screens.game_details.GameDetailsViewModel
import com.example.gamecollection.ui.screens.login.LoginScreen
import com.example.gamecollection.ui.screens.login.LoginViewModel
import com.example.gamecollection.ui.screens.profile_view.ProfileScreen
import com.example.gamecollection.ui.screens.profile_view.ProfileScreenViewModel
import com.example.gamecollection.ui.theme.GameCollectionTheme
import com.example.gamecollection.utils.Constants
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginVM = ViewModelProvider(this)[LoginViewModel::class.java]
            val profileVM = ViewModelProvider(this)[ProfileScreenViewModel::class.java]
            val detailsVM = ViewModelProvider(this)[GameDetailsViewModel::class.java]
            App(loginVM,profileVM,detailsVM)
        }
    }

}

@Composable
fun App( loginViewModel: LoginViewModel, profileViewModel: ProfileScreenViewModel, detailsViewModel: GameDetailsViewModel)  {
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenPaths.Login.name) {
        composable(ScreenPaths.Login.name) {
            LoginScreen(loginViewModel, navController)
        }
        composable(
            ScreenPaths.ProfileView.name+"/{email}"
        ) {
                navBackStackEntry ->
            val email = navBackStackEntry.arguments?.getString("email")
            if (email != null) {
                ProfileScreen(profileViewModel,navController,email=email)
            }
        }
        composable(
            ScreenPaths.DetailView.name + "/{gameName}"
        ) {
                navBackStackEntry ->
            /* Extracting the id from the route */
            val gameName = navBackStackEntry.arguments?.getString("gameName")
            /* We check if is null */
            DetailsScreen(detailsViewModel, gameName = gameName, navController)
        }
    }
}



