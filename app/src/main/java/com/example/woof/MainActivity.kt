package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.woof.ui.theme.LolTheme
import com.example.woof.dataResource.CampeonDataSource


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LolApp()
                }
            }
        }
    }
}


@Composable
fun LolApp() {
    val dataSource = CampeonDataSource()
    val campeones = dataSource.getCampeones()

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            LolTopAppBar()
        }) { it ->
        LazyColumn(contentPadding = it) {
            items(campeones) {

                Carta(campeon = it, modifier = Modifier)

            }
        }
    }
}


/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 */
@Preview
@Composable
fun WoofPreview() {
    LolTheme(
        darkTheme = false
    ) {
        LolApp()
    }
}

@Preview
@Composable
fun WoofDarkThemePreview() {
    LolTheme(darkTheme = true) {
        LolApp()
    }
}
