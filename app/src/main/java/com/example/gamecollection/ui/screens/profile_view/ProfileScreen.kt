package com.example.gamecollection.ui.screens.profile_view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.gamecollection.R
import com.example.gamecollection.data.GameModel
import com.example.gamecollection.ui.navigation.ScreenPaths
import com.example.gamecollection.ui.theme.Exo
import com.example.gamecollection.ui.theme.Hammersmith

@Composable
fun ProfileScreen(viewModel: ProfileScreenViewModel,navController: NavController,email:String){
    


    LaunchedEffect(Unit) {
        viewModel.getGamesFirebase(email)
    }
    Box(
        Modifier
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
            .fillMaxSize()
            .padding(16.dp))
    {
        profile(Modifier.align(Alignment.TopCenter),viewModel,email,navController)
    }


}
@Composable
fun profile(modifier: Modifier,viewModel: ProfileScreenViewModel,email:String,navController: NavController){
    val uiState by viewModel.uiState.collectAsState()
    val loading by viewModel.loading.observeAsState()
    val gameName by viewModel.gameName.observeAsState(initial = "")
    Column(modifier) {

        if(loading == true){
            Spacer(modifier = Modifier.height(250.dp))
            loadingProgress(modifier=modifier.align(CenterHorizontally))
        }
        else{

            HeaderComponentProfile(onBackClick = { viewModel.onBackButtonClick(navController) }, onSearchClick = { viewModel.onSearchGame(navController) },gameName) {viewModel.onChangeGameName(it)}
            profileCollectionTitle(Modifier.align(CenterHorizontally))
            if(uiState.games.isEmpty()){
                Spacer(modifier = Modifier.height(50.dp))
                
                emptyCollection(Modifier.align(CenterHorizontally))
            }
            else{
                Spacer(modifier = Modifier.height(10.dp))
                GameList(uiState.games,navController)
            }
        }


    }
}
@Composable
fun emptyCollection(modifier: Modifier){
    Text(text = "  Your collection is empty, try searching for your ",
        fontFamily= Exo,
        fontSize=16.sp,
        color = Color.White,
        modifier=modifier)
    Text(text = "favourite games above",
        fontFamily= Exo,
        fontSize=16.sp,
        color = Color.White,
        modifier=modifier)
    Image(painter = painterResource(id = R.drawable.emptycollection), contentDescription ="a", contentScale = ContentScale.FillBounds, modifier = modifier)
}
@Composable
fun profileCollectionTitle(modifier: Modifier){
    Text(text ="MY COLLECTION",
        fontFamily= Hammersmith,
        fontSize=28.sp,
        color = colorResource(id = R.color.button),
        fontWeight = FontWeight.Bold,
        modifier=modifier)
}
@Composable
fun HeaderComponentProfile(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    gameName: String,
    onValueChange:(String)->Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onBackClick() },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                value = gameName,
                onValueChange = onValueChange,
                placeholder = { Text(text = "Search", fontFamily= Exo,
                                                    fontSize=18.sp,
                                                    color = Color.White
                                                    ,textAlign = TextAlign.Center)
                              },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 18 .sp,
                    fontFamily = Exo,
                    color= Color.White
                )
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        IconButton(
            onClick = { onSearchClick() },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
    }
}
@Composable
fun loadingProgress(modifier: Modifier){
    CircularProgressIndicator(
        color = colorResource(id = R.color.button),
        modifier = modifier
            .size(60.dp, 60.dp)
            .padding(2.dp, 70.dp)
    )
}

@Composable
fun GameList(games: ArrayList<GameModel>, navController: NavController) {
    LazyVerticalGrid(columns = GridCells.Fixed(3), content = {
        items(games){ game-> Game(game,navController)}
    } )
}
@Composable
fun Game(game:GameModel?,navController: NavController){
    Card(
        Modifier
            .padding(5.dp, 5.dp)
            .height(150.dp)
            .width(150.dp)
            .clickable {
                if (game != null) {
                    navController.navigate(ScreenPaths.DetailView.name + "/" + game.slug)
                }
            }
        ,elevation = 10.dp
    )
    {
        if (game != null) {
            AsyncImage(
                contentScale = ContentScale.Crop,
                model = game.background_image,
                contentDescription = null
            )
        }
    }
}
@Composable
fun searchGameButton(navController: NavController,gameName: String){
    Image(painter = painterResource(id = R.drawable.searchicon), contentDescription = "search icon",
        Modifier
            .size(40.dp, 40.dp)
            .clickable {

            })
    //Button(onClick = { /*TODO*/ }, Modifier.size(40.dp,40.dp)) { }
}
@Composable
fun GameSearchText(gameName: String, onValueChange:(String)->Unit) {
    TextField(
        value = gameName,
        onValueChange ={onValueChange(it)},
        modifier= Modifier
            .fillMaxWidth()
            .padding(start = 60.dp, 5.dp, 0.dp, 5.dp)
            .height(30.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors=TextFieldDefaults.textFieldColors(),
        placeholder = { Text(text = "Search new game") }
    )
}