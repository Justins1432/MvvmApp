package com.example.mvvmapp.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapp.data.AuthorRepository

class AuthorsViewModelFactory (private val authorRepository: AuthorRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthorsViewModel(authorRepository) as T
    }
}