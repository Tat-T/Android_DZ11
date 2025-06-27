package com.example.android_dz_11.data.di

import com.example.android_dz_11.data.dao.ShoppingListDao
import com.example.android_dz_11.data.datasource.LocalShoppingListDataSource
import com.example.android_dz_11.data.datasource.LocalShoppingListDataSourceImpl
import com.example.android_dz_11.data.repository.ShoppingListRepositoryImpl
import com.example.android_dz_11.domain.repository.ShoppingListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideShoppingListRepository(localDataSource: LocalShoppingListDataSource): ShoppingListRepository
    {
        return ShoppingListRepositoryImpl(localDataSource)
    }

    @Provides
    fun provideShoppingListLocalDataSource(
        shoppingListDao: ShoppingListDao
    ): LocalShoppingListDataSource
    {
        return LocalShoppingListDataSourceImpl(shoppingListDao)
    }
}

