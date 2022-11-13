package com.singularity_code.modsample.splash.ui.screen.splash

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
import com.singularity_code.control.provider.sample.mmdexample.MMDExampleSpace
import com.singularity_code.control.provider.sample.pokemon.PokemonSpace
import com.singularity_code.control.provider.sample.todolist.TodoSpace
import com.singularity_code.core.common.util.logDebug
import com.singularity_code.core.ui.theme.ContentThemeWrapper
import com.singularity_code.core.ui.util.toDp
import com.singularity_code.modsample.splash.ui.navigation.SplashPortal

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
                TodoSpace.Pld()
            ) {
                logDebug("Back from Todo List trip $it")
            }
        }

        Spacer(
            modifier = Modifier
                .height(16.toDp)
        )

        ArrowButton(
            text = "Go to Pokemon Home"
        ) {
            portal?.goToPokemonHome(
                PokemonSpace.Pld()
            ) {
                logDebug("Back from Pokemon trip $it")
            }
        }

        Spacer(
            modifier = Modifier
                .height(16.toDp)
        )

        ArrowButton(
            text = "Go to MMD Example"
        ) {
            portal?.goToMMDExample(
                MMDExampleSpace.Pld()
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