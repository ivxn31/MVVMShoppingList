package com.developer.mvvmshoppinglist.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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

class ShoppingViewModelFactory(private val repository: ShoppingRepository):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository)as T
    }
}