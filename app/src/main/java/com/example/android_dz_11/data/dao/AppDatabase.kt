package com.example.android_dz_11.data.dao

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.android_dz_11.data.entities.ShoppingListEntity
import com.example.android_dz_11.BuildConfig
import com.example.android_dz_11.data.entities.ProductEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch

@Database(
    entities = [
        ShoppingListEntity::class,
        ProductEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun shoppingListDao(): ShoppingListDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "shopping_list_database"
                )
                    .addCallback(DatabaseCallback(context))
                    .fallbackToDestructiveMigration(false)
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class DatabaseCallback(private val context: Context): RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    populateInitialData(context)
                }
            }

            private suspend fun populateInitialData(context: Context) {
                val db = getInstance(context)

//                if (BuildConfig.DEBUG) {
                    val shoppingListDao = db.shoppingListDao()
                    val testList = ShoppingListEntity(
                        title = "Тестовый список",
                        date = System.currentTimeMillis(),
                        description = "Пример списка для тестирования"
                    )
                    shoppingListDao.insertList(testList)
//                }
            }
        }

    }
}