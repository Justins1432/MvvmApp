package com.example.mvvmapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmapp.R
import com.example.mvvmapp.viewmodel.AuthorsViewModel

class AuthorActivity : AppCompatActivity() {

    private val viewModel: AuthorsViewModel by viewModels()

    private lateinit var listAuthors: TextView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author)

        initView()
        initListener()
    }

    private fun initView() {
        listAuthors = findViewById(R.id.txtAuthors)
        btnBack = findViewById(R.id.buttonBack)
    }

    private fun initListener() {
        var text:String = ""
        viewModel.getAuthors().forEach {
            text += it.toString()
        }
        listAuthors.text = text
        btnBack.setOnClickListener {
            finish()
        }
    }

}