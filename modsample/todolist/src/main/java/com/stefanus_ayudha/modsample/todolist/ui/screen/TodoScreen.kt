package com.stefanus_ayudha.modsample.todolist.ui.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.stefanus_ayudha.core.common.util.request.Default
import com.stefanus_ayudha.core.common.util.request.Failed
import com.stefanus_ayudha.core.common.util.request.Loading
import com.stefanus_ayudha.core.common.util.request.Success
import com.stefanus_ayudha.core.ui.util.toDp
import com.stefanus_ayudha.modsample.todolist.data.model.TodoMdl
import com.stefanus_ayudha.modsample.todolist.data.payload.GetTodoListPld
import com.stefanus_ayudha.modsample.todolist.ui.screen.viewmodel.TodoViewModel

@Composable
fun TodoScreen(
    modifier: Modifier = Modifier
) = Box(
    modifier = Modifier
        .fillMaxSize()
        .then(modifier)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Content(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        DownloadButton(
            modifier = Modifier
                .padding(16.toDp)
        )
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    vm: TodoViewModel = viewModel()
) = Box(
    modifier = modifier
) {
    when (val state = vm.todoListState.collectAsState().value) {
        is Default -> Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = "Iddle"
        )

        is Failed -> Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = "Failed: ${state.e.message}"
        )

        is Loading -> ProgressBlocker(
            modifier = Modifier
                .align(Alignment.Center)
        )

        is Success -> ListContent(
            modifier = Modifier
                .align(Alignment.Center),
            list = state.value
        )
    }
}

@Composable
fun ListContent(
    modifier: Modifier = Modifier,
    list: List<TodoMdl> = listOf()
) = LazyColumn(
    modifier = modifier
) {
    list.map {
        item(it.id) {
            ListItem(item = it)
        }
    }
    item {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.toDp)
        )
    }
}


@Composable
fun ListItem(
    item: TodoMdl
) = Card(
    shape = RoundedCornerShape(8.toDp),
    modifier = Modifier
        .padding(16.toDp, 16.toDp, 16.toDp, 0.toDp)
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan)
            .padding(8.toDp)
            .height(50.toDp)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = "${item.title}",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ProgressBlocker(
    modifier: Modifier = Modifier
) = CircularProgressIndicator(
    modifier = modifier,
)

@Composable
fun DownloadButton(
    modifier: Modifier = Modifier,
    vm: TodoViewModel = viewModel()
) = Box(modifier = modifier) {

    Button(
        onClick = {
            vm.todoListState.request(payload = GetTodoListPld())
        },
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = "Load")
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    TodoScreen()
}

@Composable
@Preview(showSystemUi = false)
fun ListPreview() {
    Box {
        ListContent(list = TodoMdl.MOCK_LIST)
    }
}