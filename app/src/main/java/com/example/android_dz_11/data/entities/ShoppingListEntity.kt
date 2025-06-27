package com.example.android_dz_11.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android_dz_11.domain.model.ShoppingList

@Entity(tableName = "lists")
data class ShoppingListEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String?,
    val date: Long
) {
    fun toShoppingList(): ShoppingList {
        return ShoppingList(
            id = id,
            title = title,
            description = description,
            date = date
        )
    }
}