package com.developer.mvvmshoppinglist.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/* 
 * Capmega Soluciones Informáticas S.A.S de C.V 
 * October 2020
 * Iván Tecpanecatl 
 * ivant@capmega.com
 */

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name:String,
    @ColumnInfo(name = "item_amount")
    var amount: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}