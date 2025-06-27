package com.example.android_dz_11.domain.repository

import com.example.android_dz_11.domain.model.Products
import com.example.android_dz_11.domain.model.ShoppingList
import kotlinx.coroutines.flow.Flow

interface ShoppingListRepository {
    suspend fun getAllLists(): Flow<List<ShoppingList>>
    suspend fun getListById(id: Long): Flow<ShoppingList>
    suspend fun getProductsForList(id: Long): Flow<List<Products>>
    suspend fun updateList(id: Long)
    suspend fun deleteList(id: Long)
    suspend fun insertList(list: ShoppingList): Long
    suspend fun insertAllLists(lists: List<ShoppingList>)
}