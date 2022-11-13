package com.singularity_code.modsample.pokemon.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.singularity_code.core.common.util.viewmodel.state.onState
import com.singularity_code.core.network.GetPokemonListQuery
import com.singularity_code.core.ui.util.toDp
import com.singularity_code.modsample.pokemon.ui.screen.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    vm: HomeViewModel = viewModel(),
    modifier: Modifier = Modifier
) = Box(
    modifier = Modifier
        .fillMaxSize()
        .then(modifier)
) {

    vm.pokemonListState
        .onState(
            default = {
                Iddle()
            },
            loading = {
                LoadingPage()
            },
            failed = {
                Error(it)
            },
            success = {
                SuccessPage(it)
            }
        )
}

@Composable
fun Iddle() {

}

@Composable
fun BoxScope.LoadingPage() {
    CircularProgressIndicator(
        modifier = Modifier.align(
            Alignment.Center
        )
    )
}

@Composable
fun SuccessPage(
    data: GetPokemonListQuery.Data
) {
    LazyColumn(
        modifier = Modifier.padding(16.toDp)
    ) {
        data.pokemon_v2_pokemon.map { data ->
            item(
                key = data.id
            ) {
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = data.name)
                }
            }
        }
    }
}

@Composable
fun Error(
    e: com.singularity_code.core.common.data.model.Error
) {
    Text(text = e.message.toString())
}