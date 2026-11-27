package com.example.collectiontracker.ui.screens.camera

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.collectiontracker.ui.components.AppTopBar
import com.example.collectiontracker.ui.theme.spacing

@Composable
fun CameraScreen(
    onBack: () -> Unit,
    onPhotoTaken: () -> Unit
) {
    Scaffold(
        topBar = { AppTopBar(title = "Take photo", onBack = onBack) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(MaterialTheme.spacing.medium),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Camera preview will appear here.")
            Button(onClick = onPhotoTaken) { Text("Capture") }
        }
    }
}