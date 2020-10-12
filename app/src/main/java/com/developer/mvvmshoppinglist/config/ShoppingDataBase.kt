package com.developer.mvvmshoppinglist.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.developer.mvvmshoppinglist.dao.ShoppingDAO
import com.developer.mvvmshoppinglist.entities.ShoppingItem

/* 
 * Capmega Soluciones Informáticas S.A.S de C.V 
 * October 2020
 * Iván Tecpanecatl 
 * ivant@capmega.com
 */

@Database(
    entities = [
    ShoppingItem::class
    ],
    version = 1
)
abstract class ShoppingDataBase:RoomDatabase(){

    abstract fun getShoppingDao():ShoppingDAO

    companion object{
        @Volatile
        private var instance: ShoppingDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,
            ShoppingDataBase::class.java,"ShoppingDB.db").build()
    }
}