package com.developer.mvvmshoppinglist.listeners

import com.developer.mvvmshoppinglist.entities.ShoppingItem

/* 
 * Capmega Soluciones Informáticas S.A.S de C.V 
 * October 2020
 * Iván Tecpanecatl 
 * ivant@capmega.com
 */

interface AddDialogListener {

    fun onAddButtonClicked(item:ShoppingItem)
}