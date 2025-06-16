package com.example.android_dz_11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_dz_11.presentation.screens.lists.ListsScreen
import com.example.android_dz_11.presentation.screens.products.ProductsScreen
import com.example.android_dz_11.ui.theme.Android_DZ_11Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_DZ_11Theme {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    ProductsScreen()
    //ListsScreen()
}

