package com.example.mvvmapp.view

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.R
import com.example.mvvmapp.view.adapter.MyAdapter
import com.example.mvvmapp.viewmodel.AuthorsViewModel

class AuthorActivity : AppCompatActivity() {

    private val viewModel: AuthorsViewModel by viewModels()

    private lateinit var recyclerViewAuthors: RecyclerView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author)

        initView()
        initListener()
    }

    private fun initView() {
        recyclerViewAuthors = findViewById(R.id.RecyclerView)
        btnBack = findViewById(R.id.buttonBack)

        recyclerViewAuthors.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerViewAuthors.adapter = MyAdapter(viewModel.getAuthors()) { name ->
            getId(name)
            Toast.makeText(this, "Вы нажали на $name", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initListener() {
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun getId(name: String) {
        viewModel.id = name
    }
}
