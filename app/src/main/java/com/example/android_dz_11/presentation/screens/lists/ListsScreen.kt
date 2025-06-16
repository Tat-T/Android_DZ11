package com.example.android_dz_11.presentation.screens.lists

import android.R.attr.onClick
import android.annotation.SuppressLint
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
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListsScreen(onListClick: (Int) -> Unit) {
    val lists = listOf("List1","List2")

Scaffold (floatingActionButton = {
    FloatingActionButton(onClick = {}) {
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
                            text = list,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.weight(1f)
                            )
                        IconButton(onClick = {}) { Icon(
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