package com.stefanus_ayudha.modsample.splash.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import com.stefanus_ayudha.control.provider.sample.space.MMDExampleSpace
import com.stefanus_ayudha.control.provider.sample.space.PokemonSpace
import com.stefanus_ayudha.control.provider.sample.space.TodoSpace
import com.stefanus_ayudha.core.ui.ui.theme.ContentThemeWrapper
import com.stefanus_ayudha.core.ui.util.toDp
import com.stefanus_ayudha.modsample.splash.ui.navigation.SplashPortal

@Composable
fun SplashScreen(
    name: String = "Splash",
    portal: SplashPortal? = null,
    modifier: Modifier = Modifier
) = Box(
    modifier = Modifier
        .fillMaxSize()
        .then(modifier)
        .padding(16.toDp)
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.align(
            Alignment.BottomCenter
        )
    ) {

        ArrowButton(
            text = "Go to Todo List"
        ) {
            portal?.goToTodoList(
                TodoSpace.Payload()
            )
        }

        Spacer(
            modifier = Modifier
                .height(16.toDp)
        )

        ArrowButton(
            text = "Go to Pokemon Home"
        ) {
            portal?.goToPokemonHome(
                PokemonSpace.Payload()
            )
        }

        Spacer(
            modifier = Modifier
                .height(16.toDp)
        )

        ArrowButton(
            text = "Go to MMD Example"
        ) {
            portal?.goToMMDExample(
                MMDExampleSpace.Payload()
            )
        }

        Spacer(
            modifier = Modifier
                .height(16.toDp)
        )
    }
}

@Composable
fun ArrowButton(
    text: String,
    onClick: () -> Unit
) = Button(
    onClick = onClick,
    modifier = Modifier.fillMaxWidth()
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text)
        Spacer(
            modifier = Modifier
                .width(8.toDp)
        )
        Image(
            imageVector = Icons.Rounded.ArrowForward,
            contentDescription = "Navigate",
            colorFilter = ColorFilter.tint(
                color = Color.White
            )
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    ContentThemeWrapper {
        SplashScreen()
    }
}