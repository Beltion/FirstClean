package com.gmail.olegbeltion.firstclean.data

import com.gmail.olegbeltion.firstclean.data.net.BookCloud
import com.gmail.olegbeltion.firstclean.data.net.BookServices
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface BooksCloudDataSource {
    suspend fun fetchBooks(): List<BookCloud>

    class Base(private val services: BookServices) : BooksCloudDataSource {
        private val gson = Gson()
        private val type = object : TypeToken<List<BookCloud>>() {}.type
        override suspend fun fetchBooks(): List<BookCloud> =
            gson.fromJson(services.fetchBooks().string(), type)
    }

}

