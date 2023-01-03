package com.ddd.pollpoll.feature.login.ui

import androidx.compose.animation.core.AnimationEndReason
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ddd.pollpoll.core.ui.MyApplicationTheme
import com.ddd.pollpoll.feature.login.R

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
internal fun DustScreen(
    items: List<String>,
    onSave: (name: String) -> Unit,
    modifier: Modifier = Modifier
) {
    val circleAnimatable = remember { androidx.compose.animation.core.Animatable(-1000f) }

    LaunchedEffect(circleAnimatable) {
        val t = circleAnimatable.animateTo(
            targetValue = 0f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioHighBouncy,
                stiffness = Spring.StiffnessMediumLow
            )
        )
        if (t.endReason == AnimationEndReason.Finished) {
            circleAnimatable.animateTo(
                targetValue = -100f,
                animationSpec = infiniteRepeatable(
                    animation = TweenSpec(
                        500,
                        500

                    ),
                    repeatMode = RepeatMode.Reverse
                )

            )
        }
    }

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "미세미세") },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Place, contentDescription = "")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                }
            },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                }
            }
        )
    }) { it ->
        Surface(modifier = Modifier.padding(it)) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "(현재 위치)")
                Text(text = "금천구 가산동")
                Text(text = "2023-01-03 03:25 PM")
                Image(
                    painter = painterResource(id = R.drawable.frame_2),
                    contentDescription = "",
                    modifier = Modifier.graphicsLayer { translationY = circleAnimatable.value }
                )
                Text(text = "양호")
                Text(text = "쾌적한 날이에요~")
                DustDetailScreen()
            }
        }
    }
}

@Composable
fun DustDetailScreen() {
}

// Previews

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MyApplicationTheme {
        DustScreen(listOf("Cmpose", "Room", "Kotlin"), onSave = {})
    }
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview() {
    MyApplicationTheme {
        DustScreen(listOf("Compose", "Room", "Kotlin"), onSave = {})
    }
}
