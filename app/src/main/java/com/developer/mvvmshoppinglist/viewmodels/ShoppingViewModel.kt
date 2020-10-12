package com.developer.mvvmshoppinglist.viewmodels

import androidx.lifecycle.ViewModel
import com.developer.mvvmshoppinglist.entities.ShoppingItem
import com.developer.mvvmshoppinglist.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/* 
 * Capmega Soluciones Informáticas S.A.S de C.V 
 * October 2020
 * Iván Tecpanecatl 
 * ivant@capmega.com
 */

class ShoppingViewModel(private val repository: ShoppingRepository):ViewModel() {

    fun upsert(item:ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item:ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShopping() = repository.getAllShoppingItems()
}