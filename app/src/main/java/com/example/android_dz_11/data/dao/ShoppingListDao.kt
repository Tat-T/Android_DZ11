package com.example.android_dz_11.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.android_dz_11.data.entities.ProductEntity
import com.example.android_dz_11.data.entities.ShoppingListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingListDao {
    @Query("SELECT * FROM lists ORDER BY date DESC")
    fun getAllLists(): Flow<List<ShoppingListEntity>>

    @Query("SELECT * FROM lists WHERE id = :id LIMIT 1")
    fun getListById(id: Long): Flow<ShoppingListEntity>

    @Query("SELECT * FROM products WHERE listid = :id")
    fun getProductsForList(id: Long): Flow<List<ProductEntity>>

    @Insert
    suspend fun insertList(list: ShoppingListEntity)

    @Delete
    suspend fun deleteList(list: ShoppingListEntity)

    @Update
    suspend fun updateList(list: ShoppingListEntity)
}