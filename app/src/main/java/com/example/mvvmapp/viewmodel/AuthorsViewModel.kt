package com.example.mvvmapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvmapp.model.AuthorRepository
import com.example.mvvmapp.model.data.Author

class AuthorsViewModel() : ViewModel() {

    private val authorRepository = AuthorRepository()

    var id: String = ""

    fun getAuthors() = authorRepository.getAuthors()

    fun addAuthor(author: Author) = authorRepository.addAuthor(author)
}
