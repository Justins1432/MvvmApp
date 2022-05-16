package com.example.mvvmapp.util

import com.example.mvvmapp.data.AuthorRepository
import com.example.mvvmapp.data.FakeDatabase
import com.example.mvvmapp.main.AuthorsViewModelFactory

object InjectorUtils {
    fun provideAuthorViewModelFactory(): AuthorsViewModelFactory {
        val authorRepository = AuthorRepository.getInstance(FakeDatabase.getInstance().authorDao)
        return AuthorsViewModelFactory(authorRepository)
    }
}