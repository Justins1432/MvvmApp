package com.example.mvvmapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmapp.R
import com.example.mvvmapp.util.InjectorUtils

class AuthorActivity : AppCompatActivity() {
    private lateinit var listAuthors: TextView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author)
        initComponents()
    }

    private fun initComponents(){
        listAuthors = findViewById(R.id.txtAuthors)
        btnBack = findViewById(R.id.buttonBack)

        val factory = InjectorUtils.provideAuthorViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory).get(AuthorsViewModel::class.java)

        viewModel.getAuthors().observe(this, Observer { authors ->
            val stringBuilder = StringBuilder()
            authors.forEach { author ->
                stringBuilder.append("$author\n\n")
            }
            listAuthors.text = stringBuilder.toString()
        })

        btnBack.setOnClickListener {
            finish()
        }
    }

}