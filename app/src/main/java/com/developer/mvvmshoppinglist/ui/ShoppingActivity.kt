package com.developer.mvvmshoppinglist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.developer.mvvmshoppinglist.R
import com.developer.mvvmshoppinglist.config.ShoppingDataBase
import com.developer.mvvmshoppinglist.repositories.ShoppingRepository
import com.developer.mvvmshoppinglist.viewmodels.ShoppingViewModel
import com.developer.mvvmshoppinglist.viewmodels.ShoppingViewModelFactory

/* 
 * Capmega Soluciones Informáticas S.A.S de C.V 
 * October 2020
 * Iván Tecpanecatl 
 * ivant@capmega.com
 */

class ShoppingActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_activity)

        val dataBase = ShoppingDataBase(this)
        val repository = ShoppingRepository(dataBase)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)
    }
}