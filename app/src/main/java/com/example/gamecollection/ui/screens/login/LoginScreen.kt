package com.example.gamecollection.ui.screens.login

import android.graphics.RuntimeShader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gamecollection.R
import com.example.gamecollection.network.LoginResult
import com.example.gamecollection.ui.theme.Exo
import com.example.gamecollection.ui.theme.Purple500
import com.example.gamecollection.ui.theme.Purple700
import com.example.gamecollection.ui.theme.Retro
import org.intellij.lang.annotations.Language

@Composable
fun LoginScreen(viewModel:LoginViewModel,navController: NavController){
    LaunchedEffect(Unit) {
        viewModel.checkUserLogged()
    }
    Box(
        Modifier
            .background(color = colorResource(id = R.color.background))
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF2C2C2C),
                        Color(0xFF1E1E1E),
                        Color(0xFF141414),
                        Color(0xFF0A0A0A)
                    )
                )
            )
    ){
        Login(Modifier.align(Alignment.TopCenter), viewModel,navController)
        
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel,navController: NavController) {
    val email:String by viewModel.email.observeAsState(initial="")
    val password:String by viewModel.password.observeAsState(initial="")
    val loginResult: LoginResult? by viewModel.loginResult.observeAsState()

    Column(modifier) {
        Spacer(modifier = Modifier.padding(20.dp))
        LogoImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(14.dp))
        Companies(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(20.dp))
        EmailText(email) { viewModel.onChangeEmail(it) }
        Spacer(modifier = Modifier.padding(8.dp))
        PasswordText(password) { viewModel.onChangePassword(it) }
        Spacer(modifier = Modifier.padding(20.dp))
        LoginButton(){viewModel.login(email,password,navController)}
        Spacer(modifier = Modifier.padding(16.dp))
        SignUpButton(){viewModel.signUp(email,password,navController)}
        Spacer(modifier = Modifier.padding(8.dp))
        when (loginResult) {
            is LoginResult.Success -> {
                viewModel.correctDataToast(LocalContext.current)
            }
            is LoginResult.Error -> {
                viewModel.wrongDataToast(LocalContext.current)
            }
            is LoginResult.EmailUsed ->{
                viewModel.usedEmailToast(LocalContext.current)
            }
            else -> {  }
        }
    }
}

@Composable
fun LoginButton( onLogin: () -> Unit) {


    Button(onClick = {
        onLogin()
                     }, modifier = Modifier
        .fillMaxWidth()
        .height(48.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.button),
        disabledBackgroundColor = colorResource(id =R.color.french_grey)
    )) {
        Text(text = "Log In", fontFamily = Retro)
    }
}
@Composable
fun SignUpButton(onSignUp:()->Unit) {
    Button(onClick = {
        onSignUp()
                     },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.button),
            disabledBackgroundColor = colorResource(id =R.color.french_grey)
        )) {
        Text(text = "Sign up", fontFamily = Retro)
    }
}

@Composable
fun PasswordText(password:String, onValueChange: (String) -> Unit) {
    TextField(value = password,
        onValueChange ={onValueChange(it)},
        modifier= Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(
                BorderStroke(2.dp, colorResource(id = R.color.button)),
                shape = RoundedCornerShape(20.dp)
            ),
        visualTransformation= PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        textStyle = androidx.compose.ui.text.TextStyle(
            fontSize = 18 .sp,
            fontFamily = Exo
        ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorResource(id = R.color.subtle),
            cursorColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = Color.White
        ),
        placeholder = {
            Text(text = "Password",
                fontFamily= Exo,
                fontSize=18.sp,
                color = Color.White,)
        } )
}

@Composable
fun EmailText(email: String, onValueChange:(String)->Unit) {
    TextField(
        value = email,
        textStyle = androidx.compose.ui.text.TextStyle(
            fontSize = 18 .sp,
            fontFamily = Exo
        ),
        onValueChange ={onValueChange(it)},
        modifier= Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(
                BorderStroke(2.dp, colorResource(id = R.color.button)),
                shape = RoundedCornerShape(20.dp)
            ),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorResource(id = R.color.subtle),
            cursorColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = Color.White
        ),
        placeholder = { Text(text = "Email",
                            fontFamily= Exo,
                            fontSize=18.sp,
                            color = Color.White,) }
    )
}

@Composable
fun LogoImage(modifier: Modifier){
    Image(painter= painterResource(id = R.drawable.logo3), contentDescription = "Logo", modifier = modifier)
}
@Composable
fun Companies(modifier: Modifier){
    Image(painter= painterResource(id = R.drawable.pacmans), contentDescription = "Logo", modifier = modifier)
}




