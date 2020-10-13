package com.developer.mvvmshoppinglist.config

import android.app.Application
import com.developer.mvvmshoppinglist.repositories.ShoppingRepository
import com.developer.mvvmshoppinglist.viewmodels.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/* 
 * Capmega Soluciones Informáticas S.A.S de C.V 
 * October 2020
 * Iván Tecpanecatl 
 * ivant@capmega.com
 */

class ShoppingApplication: Application(),KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind() from singleton { ShoppingDataBase(instance()) }
        bind() from singleton { ShoppingRepository(instance()) }
        bind() from provider { ShoppingViewModelFactory(instance()) }
    }
}