package com.example.android_dz_11.domain.model

import java.util.Date

data class ShoppingList(
    val id: Int = 0,
    val title: String,
    val date: Long = System.currentTimeMillis(),
    val description: String?
) {
    fun formattedDate() : String {
        return Date(date).toString()
    }
}