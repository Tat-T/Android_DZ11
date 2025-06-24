package com.example.android_dz_11.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android_dz_11.domain.model.ShoppingList

@Composable
fun ShoppinglistItem (
    list: ShoppingList,
    onListClick: (Int) -> Unit,
    onEditListClick:(Int) -> Unit
)  {
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable(onClick = {onListClick(list.id)})
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