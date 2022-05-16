package com.example.mvvmapp.data

class AuthorRepository private constructor(private val authorsDao: FakeAuthorsDao){

    fun addAuthor(author: Author){
        authorsDao.addAuthor(author)
    }

    fun getAuthors() = authorsDao.getAuthors()

    companion object {
        @Volatile private var instance: AuthorRepository? = null

        fun getInstance(authorsDao: FakeAuthorsDao) = instance ?: synchronized(this){
            instance ?: AuthorRepository(authorsDao).also { instance = it }
        }
    }


}