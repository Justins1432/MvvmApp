package com.example.mvvmapp.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmapp.R
import com.example.mvvmapp.data.Author
import com.example.mvvmapp.util.InjectorUtils

class MainActivity : AppCompatActivity() {
    private lateinit var edtSurname: EditText
    private lateinit var edtName: EditText
    private lateinit var edtFathername: EditText
    private lateinit var createAuthor: Button
    private lateinit var openList: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
    }

    private fun initComponents() {
        edtSurname = findViewById(R.id.ediTextSurname)
        edtName = findViewById(R.id.ediTextName)
        edtFathername = findViewById(R.id.ediTextFathername)
        createAuthor = findViewById(R.id.btnCreate)
        openList = findViewById(R.id.openListAuthors)

        val factory = InjectorUtils.provideAuthorViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory).get(AuthorsViewModel::class.java)

        createAuthor.setOnClickListener {
            val surname = edtSurname.text.toString()
            val name = edtName.text.toString()
            val fathername = edtFathername.text.toString()

            val author = Author(surname, name, fathername)
            viewModel.addAuthor(author)

            edtSurname.setText("")
            edtName.setText("")
            edtFathername.setText("")

            Toast.makeText(this, "Автор добавлен!", Toast.LENGTH_SHORT).show()
        }

        openList.setOnClickListener {
            val intent = Intent(this, AuthorActivity::class.java)
            startActivity(intent)
        }

    }

}