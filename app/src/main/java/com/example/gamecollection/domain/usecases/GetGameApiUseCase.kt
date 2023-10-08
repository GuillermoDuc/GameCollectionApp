package com.example.gamecollection.domain.usecases

import com.example.gamecollection.data.GameModel
import com.example.gamecollection.network.ApiService
import com.example.gamecollection.utils.Constants
import com.example.gamecollection.utils.FormatHelper
import com.google.android.gms.common.api.ApiException
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
@Module
@InstallIn(SingletonComponent::class)
class GetGameApiUseCase @Inject constructor(private val retrofit: Retrofit) {
    suspend operator fun invoke (gameSlug:String): GameModel? {
        var game=retrofit.create(ApiService::class.java).getGameByName(FormatHelper.formatGameName(gameSlug)+Constants.API_KEY).body()
        return if(game?.redirect == true){
            game=retrofit.create(ApiService::class.java).getGameByName(FormatHelper.formatGameName(game.slug.toString())+Constants.API_KEY).body()
            game
        } else game
    }
}