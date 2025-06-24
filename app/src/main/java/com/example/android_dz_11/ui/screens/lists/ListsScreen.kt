package com.example.android_dz_11.presentation.screens.lists

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

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
            Card (modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable(onClick = {onListClick(1)})
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment =  Alignment.CenterVertically) {
                        Text(
                            text = list.title,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.weight(1f)
                            )
                        // кнопка редактирования
                        IconButton(onClick = {onEditListClick(1)}) {
                            Icon(
                            Icons.Default.Edit,
                            contentDescription = "Редактировать список",
                            tint = MaterialTheme.colorScheme.tertiary
                        )}

                        // Кнопка удаления
                        IconButton(onClick = {}) {
                            Icon(
                            Icons.Default.Delete,
                            contentDescription = "Удалить список",
                            tint = MaterialTheme.colorScheme.error
                        )}
                    }
                }
            }
        }
    }
}
}