package com.example.collectiontracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.collectiontracker.ui.screens.camera.CameraScreen
import com.example.collectiontracker.ui.screens.detail.ItemDetailScreen
import com.example.collectiontracker.ui.screens.edit.AddEditItemScreen
import com.example.collectiontracker.ui.screens.list.CollectionListScreen
import com.example.collectiontracker.ui.screens.settings.SettingsScreen
import com.example.collectiontracker.ui.theme.ThemeMode

@Composable
fun AppNavHost(
    navController: NavHostController,
    themeMode: ThemeMode,
    onThemeModeChange: (ThemeMode) -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.CollectionList.route,
        modifier = modifier
    ) {
        composable(Screen.CollectionList.route) {
            CollectionListScreen(
                onItemClick = { id ->
                    navController.navigate(Screen.ItemDetail.createRoute(id))
                },
                onAddClick = {
                    navController.navigate(Screen.AddEditItem.createRoute())
                },
                onSettingsClick = {
                    // launchSingleTop: tapping Settings twice doesn't stack two copies
                    navController.navigate(Screen.Settings.route) { launchSingleTop = true }
                }
            )
        }

        composable(
            route = Screen.ItemDetail.route,
            arguments = listOf(
                navArgument(Screen.ItemDetail.ARG_ITEM_ID) { type = NavType.LongType }
            )
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getLong(Screen.ItemDetail.ARG_ITEM_ID) ?: 0L
            ItemDetailScreen(
                itemId = itemId,
                onBack = { navController.navigateUp() },
                onEditClick = { id ->
                    navController.navigate(Screen.AddEditItem.createRoute(id))
                }
            )
        }
            composable(
            route = Screen.AddEditItem.route,
            arguments = listOf(
                navArgument(Screen.AddEditItem.ARG_ITEM_ID) {
                    type = NavType.LongType
                    defaultValue = Screen.AddEditItem.NEW_ITEM_ID
                }
            )
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getLong(Screen.AddEditItem.ARG_ITEM_ID)
                ?: Screen.AddEditItem.NEW_ITEM_ID
            AddEditItemScreen(
                itemId = itemId,
                onBack = { navController.navigateUp() },
                onSaved = { navController.navigateUp() },
                onTakePhotoClick = { navController.navigate(Screen.Camera.route) }
            )
        }

        composable(Screen.Camera.route) {
            CameraScreen(
                onBack = { navController.navigateUp() },
                onPhotoTaken = { navController.navigateUp() }
            )
        }

        composable(Screen.Settings.route) {
            SettingsScreen(
                themeMode = themeMode,
                onThemeModeChange = onThemeModeChange,
                onBack = { navController.navigateUp() }
            )
        }
    }
}