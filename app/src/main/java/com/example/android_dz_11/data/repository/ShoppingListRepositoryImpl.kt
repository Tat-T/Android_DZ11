package com.example.android_dz_11.data.repository

import com.example.android_dz_11.data.datasource.LocalShoppingListDataSource
import com.example.android_dz_11.domain.model.Products
import com.example.android_dz_11.domain.model.ShoppingList
import com.example.android_dz_11.domain.repository.ShoppingListRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ShoppingListRepositoryImpl @Inject constructor(
    private val localDataSource:  LocalShoppingListDataSource
) : ShoppingListRepository {
    override suspend fun getAllLists(): Flow<List<ShoppingList>> {
        return localDataSource.getAllLists().map { it.map { it.toShoppingList()} }
    }

    override suspend fun getListById(id: Long): Flow<ShoppingList> {
       return localDataSource.getListById(id).map {it.toShoppingList() }
    }

    override suspend fun getProductsForList(id: Long): Flow<List<Products>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateList(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteList(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun insertList(list: ShoppingList): Long {
        TODO("Not yet implemented")
    }

    override suspend fun insertAllLists(lists: List<ShoppingList>) {
        TODO("Not yet implemented")
    }
}

