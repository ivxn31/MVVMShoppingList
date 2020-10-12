package com.developer.mvvmshoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developer.mvvmshoppinglist.R
import com.developer.mvvmshoppinglist.entities.ShoppingItem
import com.developer.mvvmshoppinglist.viewmodels.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

/* 
 * Capmega Soluciones Informáticas S.A.S de C.V 
 * October 2020
 * Iván Tecpanecatl 
 * ivant@capmega.com
 */

class ShoppingAdapter(var items:List<ShoppingItem>,private val viewModel:ShoppingViewModel):
    RecyclerView.Adapter<ShoppingAdapter.ShoppingVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingVH(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ShoppingVH, position: Int) {
        val currentShoppingItem = items[position]

        holder.itemView.tvName.text = currentShoppingItem.name
        holder.itemView.tvAmount.text = "${currentShoppingItem.amount}"

        holder.itemView.ivDelete.setOnClickListener{
            viewModel.delete(currentShoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener{
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }

        holder.itemView.ivMinus.setOnClickListener{
            if(currentShoppingItem.amount > 0){
                currentShoppingItem.amount--
                viewModel.upsert(currentShoppingItem)
            }
        }
    }



    inner class ShoppingVH(itemView: View):RecyclerView.ViewHolder(itemView){

    }


}