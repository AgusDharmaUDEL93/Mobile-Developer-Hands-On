package dev.udel.mobiledeveloperhandson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.udel.mobiledeveloperhandson.ui.theme.MobileDeveloperHandsOnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileDeveloperHandsOnTheme {
                HomeView()
            }
        }
    }
}

@Composable
fun HomeView(modifier: Modifier = Modifier) {

    var count by remember {
        mutableIntStateOf(0)
    }

    Scaffold(modifier = modifier.fillMaxSize(), floatingActionButton = {
        FloatingActionButton(onClick = {
            count++
        }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Number")
        }
    }) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$count", fontSize = 24.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview(modifier: Modifier = Modifier) {
    HomeView()
}