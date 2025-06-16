package com.example.android_dz_11.presentation.screens.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen () {
    val products = listOf("Product 1", "Product 2")

    Scaffold (
        topBar = {
            TopAppBar(title = { Text("List 1") }, actions = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Добавить покупку"
                    )
                }
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Добавить покупку"
                    )
                }
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(products) { product ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .clickable(onClick = {}),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row (
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Название продукта и чекбокс
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)){
                            Checkbox(
                                checked = false,
                                onCheckedChange = {},
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Column {
                                Text(
                                    text = product,
                                    style = MaterialTheme.typography.bodyLarge,
                                    // TODO: replace later
                                    textDecoration = if (product == "Product 1") TextDecoration.LineThrough else null,
                                    color = if (product == "Product 1") MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                                    else MaterialTheme.colorScheme.onSurface
                                )
                                // Количество единиц измерения
                                Text(
                                    text = "1 шт.", style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                                )
                            }
                        }
                        // Кнопка удаления
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.Delete,
                                contentDescription = "Удалить продукт",
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }
        }
    }
}