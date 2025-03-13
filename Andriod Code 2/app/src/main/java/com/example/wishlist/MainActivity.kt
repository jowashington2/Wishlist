package com.example.wishlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var wishlistAdapter: WishlistAdapter
    private val wishlistItems = mutableListOf<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        wishlistAdapter = WishlistAdapter(wishlistItems)
        recyclerView.adapter = wishlistAdapter

        val itemNameInput = findViewById<EditText>(R.id.editItemName)
        val itemPriceInput = findViewById<EditText>(R.id.editItemPrice)
        val itemUrlInput = findViewById<EditText>(R.id.editItemUrl)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = itemNameInput.text.toString().trim()
            val price = itemPriceInput.text.toString().trim()
            val url = itemUrlInput.text.toString()

            if (name.isNotEmpty() && price.isNotEmpty() && url.isNotEmpty()) {
                val newItem = WishlistItem(name, price, url)
                wishlistItems.add(newItem)
                wishlistAdapter.notifyItemInserted(wishlistItems.size - 1)  // Notify adapter that a new item is added


                itemNameInput.text.clear()
                itemPriceInput.text.clear()
                itemUrlInput.text.clear()
            }
        }
    }
}

