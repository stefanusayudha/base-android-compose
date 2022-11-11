package com.stefanus_ayudha.modsample.mmdexample.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.stefanus_ayudha.core.common.util.request.Default
import com.stefanus_ayudha.core.common.util.request.Failed
import com.stefanus_ayudha.core.common.util.request.Loading
import com.stefanus_ayudha.core.common.util.request.Success
import com.stefanus_ayudha.core.ui.util.toDp
import com.stefanus_ayudha.modsample.mmdexample.ui.screen.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    vm: HomeViewModel = viewModel()
) = Box(
    modifier = Modifier.fillMaxSize()
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.toDp)
    ) {

        Text(
            text = "Module to Module Dependency Example",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(
            modifier = Modifier.height(32.toDp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.toDp)
            ) {
                Text(
                    text = "This Data From Pokemon Space Station",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(
                    modifier = Modifier
                        .height(16.toDp)
                )
                Text(
                    text = with(vm.pokemonState.collectAsState().value) {
                        when (this) {
                            is Default -> "Iddle"
                            is Failed -> "Error: ${e.message}"
                            is Loading -> "Loading.."
                            is Success -> "id: ${value.id} \nname: ${value.name}"
                        }
                    }

                )
            }

        }

    }
}