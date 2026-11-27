package com.example.collectiontracker.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.collectiontracker.ui.components.AppTopBar
import com.example.collectiontracker.ui.theme.spacing

@Composable
fun ItemDetailScreen(
    itemId: Long,
    onBack: () -> Unit,
    onEditClick: (Long) -> Unit
) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Item details",
                onBack = onBack,
                actions = {
                    IconButton(onClick = { onEditClick(itemId) }) {
                        Icon(Icons.Filled.Edit, contentDescription = "Edit item")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(MaterialTheme.spacing.medium),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
        ) {
            Text("Item #$itemId", style = MaterialTheme.typography.headlineMedium)
            Text("Photo, value and condition will appear here.")
        }
    }
}