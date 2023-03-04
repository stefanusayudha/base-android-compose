package com.singularity_code.mmdexample.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.singularity_code.core.common.util.mapState
import com.singularity_code.core.ui.util.toDp
import com.singularity_code.mmdexample.ui.screen.viewmodel.HomeViewModel

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
                    text = vm.pokemonState
                        .mapState(
                            { "" },
                            { "Loading.." },
                            { "Error: ${it.message}" },
                            { "id: ${it.id} \nname: ${it.name}" },
                        )
                )
            }

        }

    }
}