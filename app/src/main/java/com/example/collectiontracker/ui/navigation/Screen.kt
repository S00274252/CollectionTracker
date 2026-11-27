package com.example.collectiontracker.ui.navigation

sealed class Screen(val route: String) {
    data object CollectionList : Screen("collection_list")

    data object ItemDetail : Screen("item_detail/{itemId}") {
        const val ARG_ITEM_ID = "itemId"
        fun createRoute(itemId: Long) = "item_detail/$itemId"
    }
    data object AddEditItem : Screen("add_edit_item?itemId={itemId}") {
        const val ARG_ITEM_ID = "itemId"
        const val NEW_ITEM_ID = -1L

        fun createRoute(itemId: Long = NEW_ITEM_ID) = "add_edit_item?itemId=$itemId"
    }
    data object Camera : Screen("camera")

    data object Settings : Screen("settings")
}