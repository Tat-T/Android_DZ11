package com.example.android_dz_11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_dz_11.ui.components.ShoppingListApp
import com.example.android_dz_11.ui.screens.lists.EditListsScreen
import com.example.android_dz_11.ui.screens.lists.ListsScreen
import com.example.android_dz_11.ui.screens.products.ProductsScreen
import com.example.android_dz_11.ui.theme.Android_DZ_11Theme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_DZ_11Theme {
              ShoppingListApp()
            }
        }
    }
}




