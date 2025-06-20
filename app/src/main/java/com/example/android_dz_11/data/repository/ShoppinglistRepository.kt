package com.example.android_dz_11.data.entities.repository

import com.example.android_dz_11.domain.model.ShoppingList
import kotlinx.coroutines.flow.Flow

interface ShoppinglistRepository {
    suspend fun getAllLists(): Flow<List<ShoppingList>>
}