package com.example.gamecollection.data

data class GameModel(
    val name:String?,
    val description:String?,
    val metacritic:Int?,
    val released:String?,
    val background_image:String?,
    val developers:List<DeveloperModel>?,
    val genres:List<GenreModel>?,
    val slug:String?,
    val redirect:Boolean?
)
