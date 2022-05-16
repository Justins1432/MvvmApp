package com.example.mvvmapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.mvvmapp.R
import com.example.mvvmapp.model.data.Author
import com.example.mvvmapp.viewmodel.AuthorsViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: AuthorsViewModel by viewModels()

    private lateinit var edtSurname: EditText
    private lateinit var edtName: EditText
    private lateinit var edtFathername: EditText
    private lateinit var createAuthor: Button
    private lateinit var openList: Button


    /* override fun */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initListener()

        Log.d("test", "MainActivity onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("test", "MainActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("test", "MainActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("test", "MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("test", "MainActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test", "MainActivity onDestroy")
    }

    /* private fun */

    private fun initView() {
        edtSurname = findViewById(R.id.ediTextSurname)
        edtName = findViewById(R.id.ediTextName)
        edtFathername = findViewById(R.id.ediTextFathername)
        createAuthor = findViewById(R.id.btnCreate)
        openList = findViewById(R.id.openListAuthors)
    }

    private fun initListener() {
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