package com.example.gamecollection.ui.screens.game_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.gamecollection.data.GameModel
import com.example.gamecollection.domain.usecases.AddGameFirestoreUseCase
import com.example.gamecollection.domain.usecases.GetGameApiUseCase
import com.example.gamecollection.domain.usecases.GetGamesFirestoreUseCase
import com.example.gamecollection.domain.usecases.RemoveGameFireStoreUseCase
import com.example.gamecollection.ui.navigation.ScreenPaths
import com.example.gamecollection.utils.FormatHelper
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GameDetailsViewModel @Inject constructor(private val getGameApiUseCase: GetGameApiUseCase,
                                               private val getGamesFirestoreUseCase: GetGamesFirestoreUseCase,
                                               private val addGameFirestoreUseCase: AddGameFirestoreUseCase,
                                               private val removeGameFireStoreUseCase: RemoveGameFireStoreUseCase,
                                               val firebaseAuth:FirebaseAuth): ViewModel(){
    private var userGames= ArrayList<String>()
    private val _gameName = MutableLiveData<String>()
    val gameName: LiveData<String> = _gameName
    private var _loading=MutableLiveData<Boolean>()
    var loading: LiveData<Boolean> =_loading
    var email: String? = firebaseAuth.currentUser?.email
    private var _game = MutableLiveData <GameModel?>()
    var game: LiveData <GameModel?> = _game

    private var _added=MutableLiveData<Boolean>()
    var added: LiveData<Boolean> =_added
    fun upDateUser(){
        email= firebaseAuth.currentUser?.email
    }
    fun onChangeGameName(newGameName:String){
        _gameName.value=newGameName
    }
    fun onBackButtonClick(navController: NavController){
        navController.popBackStack()
    }
    fun checkGameInCollection(gameSlug: String){
        viewModelScope.launch {
            val result=withContext(Dispatchers.IO){
                email?.let { getGamesFirestoreUseCase.getGames(it) }
            }
            if (result != null) {
                for (x in result.values){
                    for(y in x as ArrayList<String>){
                        userGames.add(y)
                    }
                }
                _added.value= userGames.contains(gameSlug)
            }
        }
    }
    fun addGame(gameSlug: String, email: String?){
        if (email != null) {
            addGameFirestoreUseCase.invoke(gameSlug,email)
        }
    }
    fun removeGame(gameSlug: String,email: String?){
        if (email != null) {
            removeGameFireStoreUseCase.invoke(gameSlug,email)
        }
    }
    fun getGame(gameName:String?){
        _loading.value=true
        viewModelScope.launch {
            val result=withContext(Dispatchers.IO){
                if (gameName != null) {
                    getGameApiUseCase.invoke(gameName)
                }
                else{ null }
            }
            println(result)
            _game.value=result
            delay(1000)
            _loading.value=false
        }
    }

    fun onSearchGame(navController: NavController){
        if(gameName.value!=null|| gameName.value?.isNotEmpty() == true)
            navController.navigate(ScreenPaths.DetailView.name + "/" + gameName.value)
    }

    fun onUnFilledFavClick() {
        _game.value?.slug?.let { addGame(it,email) }
        _added.value = true
    }

    fun onFilledFavClick() {
        _game.value?.slug?.let { removeGame(it,email) }
        _added.value = false
    }
}