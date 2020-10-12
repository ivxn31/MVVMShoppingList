package com.developer.mvvmshoppinglist.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.developer.mvvmshoppinglist.entities.ShoppingItem

/* 
 * Capmega Soluciones Informáticas S.A.S de C.V 
 * October 2020
 * Iván Tecpanecatl 
 * ivant@capmega.com
 */

@Dao
interface ShoppingDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item:ShoppingItem)

    @Delete
    suspend fun delete(item:ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems():LiveData<List<ShoppingItem>>
}