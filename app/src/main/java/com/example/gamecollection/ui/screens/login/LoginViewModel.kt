package com.example.gamecollection.ui.screens.login

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.gamecollection.domain.usecases.LogInUseCase
import com.example.gamecollection.domain.usecases.SignUpUseCase
import com.example.gamecollection.network.LoginResult
import com.example.gamecollection.ui.navigation.ScreenPaths
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val logInUseCase: LogInUseCase,
                                         private val signUpUseCase:SignUpUseCase,
                                         private val firebaseAuth: FirebaseAuth)
    : ViewModel() {
    private var _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    // Solo se podrá editar desde dentro del ViewModel de esta manera
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun wrongDataToast(context:Context){
        Toast.makeText(context, "Incorrect credentials", Toast.LENGTH_SHORT).show()
        _loginResult.value=null
    }
    fun correctDataToast(context: Context){
        Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
        _loginResult.value=null
    }
    fun usedEmailToast(context: Context){
        Toast.makeText(context, "Email already used", Toast.LENGTH_SHORT).show()
        _loginResult.value=null
    }
    fun checkUserLogged(){
        _email.value=""
        _password.value=""
        if(firebaseAuth.currentUser!=null){
            firebaseAuth.signOut()
            _loginResult.value=null
        }
    }
    fun onChangeEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun onChangePassword(newPassword: String) {
        _password.value = newPassword
    }
    fun signUp(email: String,password: String,navController: NavController){
        viewModelScope.launch {
            try{
                val result = withContext(Dispatchers.IO) {
                    signUpUseCase.signUpUseCase(email,password)
                }
                _loginResult.value = result
                if(result is LoginResult.Success){
                    navController.navigate(ScreenPaths.ProfileView.name+"/"+email)
                }
            }
            catch (ex: FirebaseAuthUserCollisionException){
                _loginResult.value = LoginResult.EmailUsed
            }

        }
    }

    fun login(email: String,password:String,navController: NavController) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                logInUseCase.LogIn(email,password)
            }
            _loginResult.value = result
            if(result is LoginResult.Success){
                navController.navigate(ScreenPaths.ProfileView.name+"/"+email)
            }

        }
    }

}