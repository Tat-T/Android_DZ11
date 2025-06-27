package com.example.android_dz_11.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_dz_11.ui.screens.lists.EditListsScreen
import com.example.android_dz_11.ui.screens.lists.ListsScreen
import com.example.android_dz_11.ui.screens.products.ProductsScreen

@Composable
fun ShoppingListApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "lists") {
        composable ("lists") {
            ListsScreen(
                onListClick = { listId -> navController.navigate("products")},
                onCreateListClick = { navController.navigate("editList")},
                onEditListClick = { listId -> navController.navigate("editList/$listId") }
            )
        }
        composable("products") {
            ProductsScreen()
        }
        composable ("editList/{listId}") {  backStackEntry ->
            val listId = backStackEntry.arguments?.getString("listId")?.toIntOrNull()
            EditListsScreen(listId)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingListAppPreview() {
    ShoppingListApp()
    ListsScreen(
        onListClick = {},
        onCreateListClick = {},
        onEditListClick = {}
    )
}