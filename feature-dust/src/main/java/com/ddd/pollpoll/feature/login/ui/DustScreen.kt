
package com.ddd.pollpoll.feature.login.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ddd.pollpoll.core.ui.MyApplicationTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier, viewModel: DustViewModel = hiltViewModel()) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
//    val items by produceState<LoginUiState>(
//        initialValue = LoginUiState.Loading,
//        key1 = lifecycle,
//        key2 = viewModel
//    ) {
//        lifecycle.repeatOnLifecycle(state = STARTED) {
//            viewModel.uiState.collect { value = it }
//        }
//    }
//    if (items is Success) {
//        LoginScreen(
//            items = (items as Success).data,
//            onSave = { name -> viewModel.addLogin(name) },
//            modifier = modifier
//        )
//    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LoginScreen(
    items: List<String>,
    onSave: (name: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        var nameLogin by remember { mutableStateOf("Compose") }
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = nameLogin,
                onValueChange = { nameLogin = it }
            )

            Button(modifier = Modifier.width(96.dp), onClick = { onSave(nameLogin) }) {
                Text("Save")
            }
        }
        items.forEach {
            Text("Saved item: $it")
        }
    }
}

// Previews

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MyApplicationTheme {
        LoginScreen(listOf("Compose", "Room", "Kotlin"), onSave = {})
    }
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview() {
    MyApplicationTheme {
        LoginScreen(listOf("Compose", "Room", "Kotlin"), onSave = {})
    }
}
