package com.example.mvvmapp.data

data class Author(val surname: String, val name: String,
                  val fathername: String){
    override fun toString(): String {
        return "$surname $name $fathername"
    }
}
