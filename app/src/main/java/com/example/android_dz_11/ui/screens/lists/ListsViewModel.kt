package com.example.android_dz_11.presentation.screens.lists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_dz_11.data.repository.ShoppingListRepository
import com.example.android_dz_11.domain.model.ShoppingList
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

@HiltViewModel
class ListsViewModel @Inject constructor(
    private val repository: ShoppingListRepository
) : ViewModel() {
    private val _lists = MutableStateFlow<List<ShoppingList>>(emptyList())
    val lists: StateFlow<List<ShoppingList>> = _lists.asStateFlow()

    init {
        loadLists()
    }

    private fun loadLists() {
        viewModelScope.launch {
            repository.getAllLists()
                .catch {
                    e -> {}
                }
                .collect {
                    {
                        _lists.value = it
                    }
                }

        }
    }

}