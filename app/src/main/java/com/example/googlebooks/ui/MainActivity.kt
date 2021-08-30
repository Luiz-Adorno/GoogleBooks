package com.example.googlebooks.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googlebooks.R
import com.example.googlebooks.adapter.BookListAdapter
import com.example.googlebooks.model.Volume
import com.example.googlebooks.repository.BookHttp
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                BookHttp.searchBook("A")
            }
            result?.items?.let {
                recyclerView.adapter = BookListAdapter(it, this@MainActivity:: openBookDetail)
            }
        }
    }

    private fun openBookDetail(volume: Volume){
        val detailIntent = Intent(this, BookDetailActivity::class.java)
        detailIntent.putExtra("book", volume)
        startActivity(detailIntent)
    }
}