package com.example.android_dz_11.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val amount: Float,
    val listId: Long,
    val checked: Boolean
)