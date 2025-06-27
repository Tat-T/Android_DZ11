package com.example.android_dz_11.ui.screens.lists

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.android_dz_11.ui.components.ShoppingListsItem

@Composable
fun ListsScreen(
    viewModel: ListsViewModel = hiltViewModel(), // автоматическое создание ViewModel
    onListClick: (Int) -> Unit,
    onCreateListClick: () -> Unit,
    onEditListClick: (Int) -> Unit
) {
    val lists by viewModel.lists.collectAsState(initial = emptyList())

Scaffold (floatingActionButton = {
    FloatingActionButton(onClick = { onCreateListClick}) {
        Icon(
            Icons.Default.Add,
            contentDescription = "Add list",
            tint = MaterialTheme.colorScheme.primary
            ) }
}) { padding ->
    LazyColumn(modifier = Modifier.padding(padding)) {
        items (lists) { list ->
            ShoppingListsItem(
                list,
                onListClick = onListClick,
                onEditListClick = onEditListClick
            )
        }
    }
}
}

@Preview(showBackground = true)
@Composable
fun PreviewListScreen(){
    ListsScreen(onListClick = {}, onEditListClick = {}, onCreateListClick = {})
}