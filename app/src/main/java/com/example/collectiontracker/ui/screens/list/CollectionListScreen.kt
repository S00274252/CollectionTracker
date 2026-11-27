package com.example.collectiontracker.ui.screens.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.collectiontracker.ui.components.AppTopBar
import com.example.collectiontracker.ui.theme.CollectionTrackerTheme
import com.example.collectiontracker.ui.theme.spacing

@Composable
fun CollectionListScreen(
    onItemClick: (Long) -> Unit,
    onAddClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    // Temporary fake data so the Detail screen can be reached
    val placeholderIds = listOf(1L, 2L, 3L)
    val spacing = MaterialTheme.spacing

    Scaffold(
        topBar = {
            AppTopBar(
                title = "My Collection",
                actions = {
                    IconButton(onClick = onSettingsClick) {
                        Icon(Icons.Filled.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Icon(Icons.Filled.Add, contentDescription = "Add item")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(spacing.medium),
            verticalArrangement = Arrangement.spacedBy(spacing.small)
        ) {
            items(placeholderIds) { id ->
                Card(
                    onClick = { onItemClick(id) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Sample item #$id",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(spacing.medium)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CollectionListScreenPreview() {
    CollectionTrackerTheme {
        CollectionListScreen(onItemClick = {}, onAddClick = {}, onSettingsClick = {})
    }
}