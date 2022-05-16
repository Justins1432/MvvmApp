package com.example.mvvmapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeAuthorsDao {
    private val authorsList = mutableListOf<Author>()
    private val authors = MutableLiveData<List<Author>>()

    init {
        authors.value = authorsList
    }

    fun addAuthor(author: Author){
        authorsList.add(author)
        authors.value = authorsList
    }

    fun getAuthors() = authors as LiveData<List<Author>>

}