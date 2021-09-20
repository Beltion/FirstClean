package com.gmail.olegbeltion.firstclean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gmail.olegbeltion.firstclean.core.BibleApp
import com.gmail.olegbeltion.firstclean.presentation.BibleAdapter
import com.gmail.olegbeltion.firstclean.presentation.Retry

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = (application as BibleApp).mainViewModel

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = BibleAdapter(object : Retry{
            override fun tryAgain() {
                viewModel.fetchBooks()
            }

        })
        recyclerView.adapter = adapter

        viewModel.observe(this, {
            adapter.update(it)
        })
        viewModel.fetchBooks()

    }
}