package com.example.mvvmapp.main

import androidx.lifecycle.ViewModel
import com.example.mvvmapp.data.Author
import com.example.mvvmapp.data.AuthorRepository

class AuthorsViewModel(private val authorRepository: AuthorRepository) : ViewModel() {
    fun getAuthors() = authorRepository.getAuthors()
    fun addAuthor(author: Author) = authorRepository.addAuthor(author)
}