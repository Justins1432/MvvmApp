package com.example.mvvmapp.data

class FakeDatabase private constructor() {
    var authorDao = FakeAuthorsDao()
        private set

    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(this){
            instance ?: FakeDatabase().also { instance = it }

        }
    }

}