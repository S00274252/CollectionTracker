package com.example.collectiontracker

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.collectiontracker.ui.theme.CollectionTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CollectionTrackerTheme {
                ThemeShowcase()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeShowcase() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Collection Tracker") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Filled.Add, contentDescription = "Add item")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp)) {
                    Text("Charizard Holo 1st Ed.", style = MaterialTheme.typography.titleMedium)
                    Text("Condition: Near Mint", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        "€350.00",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            Button(onClick = { }) { Text("Primary button") }
            OutlinedButton(onClick = { }) { Text("Outlined button") }
            AssistChip(onClick = { }, label = { Text("Trading cards") })
        }
    }
}

@Preview(name = "Light mode", showBackground = true)
@Preview(
    name = "Dark mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun ThemeShowcasePreview() {
    CollectionTrackerTheme { ThemeShowcase() }
}