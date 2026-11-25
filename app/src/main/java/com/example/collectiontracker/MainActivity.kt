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
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.collectiontracker.ui.theme.ThemeMode
import com.example.collectiontracker.ui.theme.conditionColors
import com.example.collectiontracker.ui.theme.spacing

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           var themeMode by rememberSaveable { mutableStateOf(ThemeMode.SYSTEM) }

            CollectionTrackerTheme(themeMode = themeMode) {
                ThemeShowcase(
                    selectedMode = themeMode,
                    onModeSelected = { themeMode = it }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeShowcase(
    selectedMode: ThemeMode,
    onModeSelected: (ThemeMode) -> Unit
) {
    val spacing = MaterialTheme.spacing

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
                .padding(spacing.medium),
            verticalArrangement = Arrangement.spacedBy(spacing.medium)
        ) {
            SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
                val modes = ThemeMode.entries
                modes.forEachIndexed { index, mode ->
                    SegmentedButton(
                        selected = mode == selectedMode,
                        onClick = { onModeSelected(mode) },
                        shape = SegmentedButtonDefaults.itemShape(index, modes.size)
                    ) { Text(mode.label) }
                }
            }

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(spacing.medium),
                    verticalArrangement = Arrangement.spacedBy(spacing.small)
                ) {
                    Text("Charizard Holo 1st Ed.", style = MaterialTheme.typography.titleMedium)
                    Text(
                        "€350.00",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }

            val colors = MaterialTheme.conditionColors
            Row(horizontalArrangement = Arrangement.spacedBy(spacing.small)) {
                ConditionBadge("Mint", colors.mint, colors.onBadge)
                ConditionBadge("Good", colors.good, colors.onBadge)
                ConditionBadge("Fair", colors.fair, colors.onBadge)
                ConditionBadge("Poor", colors.poor, colors.onBadge)
            }

            Button(onClick = { }) { Text("Primary button") }
            OutlinedButton(onClick = { }) { Text("Outlined button") }
        }
    }
}

@Composable
fun ConditionBadge(text: String, background: Color, textColor: Color) {
    Text(
        text = text,
        color = textColor,
        style = MaterialTheme.typography.labelMedium,
        modifier = Modifier
            .background(background, RoundedCornerShape(50))
            .padding(horizontal = MaterialTheme.spacing.small, vertical = MaterialTheme.spacing.extraSmall)
    )
}

@Preview(name = "Light mode", showBackground = true)
@Composable
fun ThemeShowcaseLightPreview() {
    CollectionTrackerTheme(themeMode = ThemeMode.LIGHT) {
        ThemeShowcase(selectedMode = ThemeMode.LIGHT, onModeSelected = {})
    }
}

@Preview(name = "Dark mode", showBackground = true)
@Composable
fun ThemeShowcaseDarkPreview() {
    CollectionTrackerTheme(themeMode = ThemeMode.DARK) {
        ThemeShowcase(selectedMode = ThemeMode.DARK, onModeSelected = {})
    }
}