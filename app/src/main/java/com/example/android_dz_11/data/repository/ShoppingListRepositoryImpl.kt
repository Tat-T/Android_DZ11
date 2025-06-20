package com.example.android_dz_11.data.entities.repository

import com.example.android_dz_11.data.entities.datasource.LocalShoppingListDataSource
import com.example.android_dz_11.domain.model.ShoppingList
import kotlinx.coroutines.flow.Flow

class ShoppingListRepositoryImpl(
    private val localDataSource:  LocalShoppingListDataSource
) : ShoppinglistRepository {
    override suspend fun getAllLists(): Flow<List<ShoppingList>> {
        TODO("Not yet implemented")
    }
}
