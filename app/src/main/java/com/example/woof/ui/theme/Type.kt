package com.example.woof.ui.theme

import androidx.compose.material3.Typography

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.woof.R

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp


val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

val Prompt = FontFamily(
    Font(R.font.prompt_blackitalic, FontWeight.Bold),
    Font(R.font.prompt_medium, FontWeight.Medium),
    Font(R.font.prompt_regular, FontWeight.Normal)
)

val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = Prompt,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Prompt,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    displayLarge = TextStyle(
        fontFamily = Prompt,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp
    )
)