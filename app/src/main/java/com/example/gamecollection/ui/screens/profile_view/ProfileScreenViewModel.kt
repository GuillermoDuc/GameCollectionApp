package com.example.gamecollection.ui.screens.profile_view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.gamecollection.data.GameModel
import com.example.gamecollection.domain.usecases.GetGameApiUseCase
import com.example.gamecollection.domain.usecases.GetGamesFirestoreUseCase
import com.example.gamecollection.ui.navigation.ScreenPaths
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
data class UiState(
    val games:ArrayList<GameModel> = ArrayList()
)
@HiltViewModel
class ProfileScreenViewModel @Inject constructor(private val getGamesFirestoreUseCase: GetGamesFirestoreUseCase,
                                                 private val getGameApiUseCase: GetGameApiUseCase)
    :ViewModel()  {

    private var gameItems = ArrayList<GameModel>()
    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()
    private var _loading=MutableLiveData<Boolean>()
    var loading: LiveData<Boolean> =_loading
    private var _gameName = MutableLiveData<String>()
    var gameName: LiveData<String> = _gameName

    fun onChangeGameName(newGameName: String) {
        _gameName.value = newGameName
    }
    fun onSearchGame(navController: NavController){
        if(gameName.value!=null|| gameName.value?.isEmpty() == true)
            navController.navigate(ScreenPaths.DetailView.name + "/" + gameName.value)
    }
    fun onBackButtonClick(navController: NavController){
        navController.popBackStack()
    }

    fun getGamesFirebase(email:String){
        _loading.value=true
        viewModelScope.launch {
            val result=withContext(Dispatchers.IO){
                getGamesFirestoreUseCase.getGames(email)
            }
            if (result != null) {
                gameItems= ArrayList<GameModel>()
                for (x in result.values){
                    for(y in x as ArrayList<String>){
                        withContext(Dispatchers.IO) {
                            getGameApiUseCase(y)?.let { gameItems.add(it) }}
                    }
                    _uiState.update { it.copy(games = gameItems ) }
                }
            }
            delay(1000)
            _loading.value=false
        }
    }
}