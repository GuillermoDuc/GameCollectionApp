package com.example.gamecollection

import android.util.JsonReader
import com.example.gamecollection.data.GameModel
import com.example.gamecollection.domain.usecases.GetGameApiUseCase
import com.example.gamecollection.domain.usecases.GetGamesFirestoreUseCase
import com.example.gamecollection.network.ApiService
import com.example.gamecollection.ui.screens.game_details.DetailsScreen
import com.example.gamecollection.ui.screens.profile_view.ProfileScreenViewModel
import com.example.gamecollection.utils.Constants
import com.example.gamecollection.utils.Constants.BASE_URL
import com.example.gamecollection.utils.FormatHelper
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun responseParseTest () {
        var game= Gson().fromJson<GameModel>(TestUtils.MockUpResponse(),GameModel::class.java)
        if(game==null || game.description==null || game.background_image==null){throw Exception("Game parse error")}
    }
}