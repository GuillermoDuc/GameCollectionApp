package com.example.gamecollection.ui.screens.game_details

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gamecollection.R
import com.example.gamecollection.data.GameModel
import com.example.gamecollection.ui.screens.profile_view.HeaderComponentProfile
import com.example.gamecollection.ui.screens.profile_view.loadingProgress
import com.example.gamecollection.ui.theme.Exo
import com.example.gamecollection.utils.FormatHelper

@Composable
fun DetailsScreen(viewModel: GameDetailsViewModel,gameName: String?,navController: NavController){
    val gameNameSearch:String by viewModel.gameName.observeAsState(initial="")
    val game:GameModel? by viewModel.game.observeAsState()
    val loading:Boolean? by viewModel.loading.observeAsState()
    val added:Boolean? by viewModel.added.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.upDateUser()
        viewModel.getGame(gameName)
        if (gameName != null) {
            viewModel.checkGameInCollection(gameName)
        }
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
            .padding(16.dp)
    ){
        when(loading){
            true ->{
                loadingProgress(Modifier.align(Alignment.TopCenter))
            }
            false -> {
                when(game?.name){
                    null -> {
                        HeaderComponentProfile(onBackClick = { viewModel.onBackButtonClick(navController) }, onSearchClick = { viewModel.onSearchGame(navController) },gameNameSearch) {viewModel.onChangeGameName(it)}
                        Spacer(modifier = Modifier.height(50.dp))
                        Text(text = " GAME NOT FOUND ",
                            fontFamily= Exo,
                            fontSize=28.sp,
                            color = colorResource(id = R.color.button),
                            modifier = Modifier.align(Alignment.TopCenter).
                                    padding(1.dp,100.dp)
                        )
                        GameNotFoundScreen(Modifier.align(Alignment.Center))
                    }
                    else -> {
                        HeaderComponent(added,onBackClick = { viewModel.onBackButtonClick(navController) }, onSearchClick = { viewModel.onSearchGame(navController) },gameNameSearch,
                            {viewModel.onChangeGameName(it)},{viewModel.onFilledFavClick()},{viewModel.onUnFilledFavClick()})

                        Spacer(Modifier.height(80.dp))
                        GameDetailsScreen(game!!,viewModel)
                    }
                }
            }
            null -> Text(text = "??")
        }
    }
}
@Composable
fun GameNotFoundScreen(modifier: Modifier){
    Box(
        modifier = modifier.size(400.dp)
    ){

        Image(painter = painterResource(id = R.drawable.gamenotfound), contentDescription ="Game not found image", contentScale = ContentScale.FillBounds)
    }
}

@Composable
fun UnfilledFavButton(onUnfilledFavClick: () -> Unit){
    Image(painter = painterResource(id = R.drawable.unfillefavorite), contentDescription ="Unfilled Fav Button", contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .size(25.dp)
            .clickable { onUnfilledFavClick() })
}
@Composable
fun FilledFavButton(onFilledFavClick: () -> Unit){
    Image(painter = painterResource(id = R.drawable.filledfavorite), contentDescription ="Filled Fav Button", contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .size(25.dp)
            .clickable { onFilledFavClick() })
}

@Composable
fun HeaderComponent(
    added:Boolean?,
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    gameName: String,
    onValueChange:(String)->Unit,
    onFilledFavClick: () -> Unit,
    onUnfilledFavClick: () -> Unit
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
                placeholder = { Text(text = "Search",
                                    fontFamily= Exo,
                                    fontSize=18.sp,
                                    color = Color.White,
                                    textAlign = TextAlign.Center) },
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
        when(added){
            true -> FilledFavButton(onFilledFavClick)
            false -> UnfilledFavButton(onUnfilledFavClick)
            null -> Text("??")
        }

    }
}
@Composable
fun GameDetailsScreen(game:GameModel,viewModel: GameDetailsViewModel) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = game.name.toString(),
                fontFamily= Exo,
                fontSize=32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(15.dp))
            if(game.developers!=null && game.developers.isNotEmpty()){
                Text(
                    text = "Developer: ${game.developers?.get(0)?.name}",
                    fontFamily= Exo,
                    fontSize=18.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            if(game.metacritic!=null){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Metacritic Score",
                        fontFamily= Exo,
                        fontSize=18.sp,
                        color = Color.White,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "${game.metacritic}/100",
                        fontFamily= Exo,
                        fontSize=18.sp,
                        color = Color.White,
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            if(game.genres!=null && game.genres.isNotEmpty()){
                Text(
                    text = "Genre: ${game.genres?.get(0)?.name.toString()}",
                    fontFamily= Exo,
                    fontSize=18.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            if(game.released!=null){
                Text(
                    text = "Release Date: ${game.released}",
                    fontFamily= Exo,
                    fontSize=18.sp,
                    color = Color.White,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            if(game.description!=null){
                Text(
                    text= FormatHelper.formatDescription(game.description.toString()),
                    fontFamily= Exo,
                    fontSize=18.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .verticalScroll(rememberScrollState())
                )
            }

        }
}

