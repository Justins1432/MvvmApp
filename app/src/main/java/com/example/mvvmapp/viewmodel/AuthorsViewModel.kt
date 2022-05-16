package com.example.mvvmapp.viewmodel


import androidx.lifecycle.ViewModel
import com.example.mvvmapp.model.data.Author
import com.example.mvvmapp.model.AuthorRepository

class AuthorsViewModel() : ViewModel() {

    private val authorRepository = AuthorRepository()

    fun getAuthors() = authorRepository.getAuthors()

    fun addAuthor(author: Author) = authorRepository.addAuthor(author)

}