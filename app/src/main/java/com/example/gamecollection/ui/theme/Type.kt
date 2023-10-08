package com.example.gamecollection.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.gamecollection.R
val Exo = FontFamily(
        Font(R.font.exo2regular),
        Font(R.font.exo2bold,FontWeight.Bold)
        )
val Retro = FontFamily(
    Font(R.font.pressstart2p_regular)
)
val Hammersmith= FontFamily(
    Font(R.font.hammersmithone_regular)
)
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = Hammersmith,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    button = TextStyle(
        fontFamily = Retro,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    h4 =TextStyle(
        fontFamily = Hammersmith,
        fontWeight = FontWeight.Normal,
        fontSize = 70.sp
    )
)