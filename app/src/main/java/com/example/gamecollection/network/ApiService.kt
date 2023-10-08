package com.example.gamecollection.network

import com.example.gamecollection.data.GameModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getGameByName(@Url url:String): Response<GameModel>
}

