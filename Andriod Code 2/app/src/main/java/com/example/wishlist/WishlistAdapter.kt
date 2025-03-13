package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter (private val items: List<WishlistItem>)  :
    RecyclerView.Adapter<WishlistAdapter.WishViewHolder>() {

    class WishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.itemName)
        val itemPrice: TextView = itemView.findViewById(R.id.itemPrice)
        val itemUrl: TextView = itemView.findViewById(R.id.itemUrl)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistAdapter.WishViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.wishlist_item,parent,false)
        return WishViewHolder(view)
    }

    override fun onBindViewHolder(holder: WishViewHolder, position: Int) {
        val currentItem = items[position]
        holder.itemName.text = currentItem.name
        holder.itemPrice.text = currentItem.price
        holder.itemUrl.text = currentItem.url
    }
    override fun getItemCount(): Int {
        return items.size
    }


}