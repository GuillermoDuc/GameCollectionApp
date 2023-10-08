package com.example.gamecollection.network

sealed class LoginResult {
    object Error:LoginResult()
    object Success:LoginResult()
    object EmailUsed:LoginResult()
}