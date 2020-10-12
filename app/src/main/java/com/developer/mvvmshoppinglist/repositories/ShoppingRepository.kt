package com.developer.mvvmshoppinglist.repositories

import com.developer.mvvmshoppinglist.config.ShoppingDataBase
import com.developer.mvvmshoppinglist.entities.ShoppingItem

/* 
 * Capmega Soluciones Informáticas S.A.S de C.V 
 * October 2020
 * Iván Tecpanecatl 
 * ivant@capmega.com
 */

class ShoppingRepository(private val db:ShoppingDataBase){


    suspend fun upsert(item:ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item:ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}