package com.example.mvvmapp.model

import com.example.mvvmapp.model.data.Author

class AuthorRepository() {
    /***
     * Добавить автора
     */
    fun addAuthor(author: Author) {
        authorsList.add(author)
    }

    /***
     * Получить автора
     */
    fun getAuthors(): List<Author> {
        return authorsList
    }

    companion object  Test {
         val authorsList = mutableListOf<Author>()
    }

}