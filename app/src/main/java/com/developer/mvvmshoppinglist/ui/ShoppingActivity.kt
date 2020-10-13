package com.developer.mvvmshoppinglist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.developer.mvvmshoppinglist.R
import com.developer.mvvmshoppinglist.adapters.ShoppingAdapter
import com.developer.mvvmshoppinglist.config.ShoppingDataBase
import com.developer.mvvmshoppinglist.entities.ShoppingItem
import com.developer.mvvmshoppinglist.listeners.AddDialogListener
import com.developer.mvvmshoppinglist.repositories.ShoppingRepository
import com.developer.mvvmshoppinglist.viewmodels.ShoppingViewModel
import com.developer.mvvmshoppinglist.viewmodels.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.shopping_activity.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

/* 
 * Capmega Soluciones Informáticas S.A.S de C.V 
 * October 2020
 * Iván Tecpanecatl 
 * ivant@capmega.com
 */

class ShoppingActivity : AppCompatActivity(), AddDialogListener, KodeinAware{

    override val kodein by kodein()
    private val factory:ShoppingViewModelFactory by instance()

    private var viewModel:ShoppingViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_activity)

        viewModel = ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingAdapter(listOf(),viewModel!!)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel?.getAllShopping()?.observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(this,this).show()
        }
    }

    override fun onAddButtonClicked(item: ShoppingItem) {
        viewModel?.upsert(item)
    }
}