package com.example.android_dz_11.data.datasource

import com.example.android_dz_11.data.dao.ShoppingListDao
import com.example.android_dz_11.data.entities.ShoppingListEntity
import com.example.android_dz_11.domain.model.Products
import com.example.android_dz_11.domain.model.ShoppingList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LocalShoppingListDataSource {
    suspend fun getAllLists(): Flow<List<ShoppingListEntity>>
    suspend fun getListById(id: Long): Flow<ShoppingListEntity>
    suspend fun getProductsForList(id: Long): Flow<List<Products>>
    suspend fun updateList(id: Long)
    suspend fun deleteList(id: Long)
    suspend fun insertList(list: ShoppingList): Long
    suspend fun insertAllLists(lists: List<ShoppingList>)
}

class LocalShoppingListDataSourceImpl @Inject constructor(
    private  val shoppingListDao: ShoppingListDao
): LocalShoppingListDataSource {
      override suspend fun getAllLists(): Flow<List<ShoppingListEntity>> {
        return  shoppingListDao.getAllLists()
    }

    override suspend fun getListById(id: Long): Flow<ShoppingListEntity> {
        return shoppingListDao.getListById(id)
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
