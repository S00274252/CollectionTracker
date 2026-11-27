package com.example.collectiontracker.ui.screens.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.collectiontracker.ui.components.AppTopBar
import com.example.collectiontracker.ui.navigation.Screen
import com.example.collectiontracker.ui.theme.spacing

@Composable
fun AddEditItemScreen(
    itemId: Long,
    onBack: () -> Unit,
    onSaved: () -> Unit,
    onTakePhotoClick: () -> Unit
) {
    val isNewItem = itemId == Screen.AddEditItem.NEW_ITEM_ID
    val spacing = MaterialTheme.spacing

    Scaffold(
        topBar = {
            AppTopBar(
                title = if (isNewItem) "Add item" else "Edit item",
                onBack = onBack
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(spacing.medium),
            verticalArrangement = Arrangement.spacedBy(spacing.medium)
        ) {
            Text(
                if (isNewItem) "Form for a new item goes here."
                else "Form for editing item #$itemId goes here."
            )

            OutlinedButton(onClick = onTakePhotoClick) {
                Icon(Icons.Filled.CameraAlt, contentDescription = null)
                Text("  Take photo")
            }

            Row(horizontalArrangement = Arrangement.spacedBy(spacing.small)) {
                OutlinedButton(onClick = onBack) { Text("Cancel") }
                Button(onClick = onSaved) { Text("Save") }
            }
        }
    }
}