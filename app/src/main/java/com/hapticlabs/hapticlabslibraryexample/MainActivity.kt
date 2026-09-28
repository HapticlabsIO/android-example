package com.hapticlabs.hapticlabslibraryexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.hapticlabs.hapticlabslibraryexample.theme.ui.HapticlabsLibraryExampleTheme
import io.hapticlabs.hapticlabsplayer.HapticlabsPlayer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HapticlabsLibraryExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    Buttons(paddingValues)
                }
            }
        }
    }
}

@Composable
fun Buttons(paddingValues: PaddingValues) {
    val context = LocalContext.current
    val hapticlabsPlayer = remember {
        HapticlabsPlayer(context)
    }
    var abortPlayback = {}

    // A button
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center, // Adds space between buttons
        horizontalAlignment = Alignment.CenterHorizontally, // Centers buttons horizontally
    ) {
        Button(onClick = {
            abortPlayback = hapticlabsPlayer.play(
                "complex.hac"
            ) {
                println("Playback terminated (auto-select)")
            }
        }) {
            Text("Play (auto-select API)")
        }
        Button(onClick = {
            hapticlabsPlayer.playHLA(
                "Android samples/button/lvl2/main.hla"
            ) {
                println("Playback terminated (HLA)")
            }
        }) {
            Text("Play HLA")
        }
        Button(onClick = {
            hapticlabsPlayer.playOGG(
                "Android samples/button/lvl3/main.ogg"
            ) {
                println("Playback terminated (OGG)")
            }
        }) {
            Text("Play OGG")
        }
        Button(onClick = {
            hapticlabsPlayer.preload(
                "complex.hac"
            )
        }) {
            Text("Preload")
        }
        Button(onClick = {
            hapticlabsPlayer.preloadOGG(
                "Android samples/button/lvl3/main.ogg"
            )
        }) {
            Text("Preload OGG")
        }
        Button(onClick = {
            hapticlabsPlayer.unload(
                "complex.hac"
            )
            println("unloaded")
        }) {
            Text("Unload")
        }
        Button(onClick = {
            hapticlabsPlayer.unloadOGG(
                "Android samples/button/lvl3/main.ogg"
            )
            println("unloaded ogg")
        }) {
            Text("Unload OGG")
        }
        Button(onClick = {
            hapticlabsPlayer.unloadAll()
            println("unloaded all")
        }) {
            Text("Unload all")
        }
        Button(onClick = {
            hapticlabsPlayer.playBuiltIn("Heavy Click")
        }) {
            Text("Play built-in (\"Heavy Click\")")
        }
        Button(onClick = {
            abortPlayback()
        }) {
            Text("Cancel playback")
        }
    }
}