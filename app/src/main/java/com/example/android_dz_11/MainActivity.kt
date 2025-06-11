package com.example.android_dz_11

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListScreen() {
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
                .clickable(onClick = {})
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

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    ListScreen()
}