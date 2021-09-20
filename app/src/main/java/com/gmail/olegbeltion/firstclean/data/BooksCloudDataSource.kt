package com.gmail.olegbeltion.firstclean.data


import com.gmail.olegbeltion.firstclean.data.net.BookCloud
import com.gmail.olegbeltion.firstclean.data.net.BookServices
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface BooksCloudDataSource {
    suspend fun fetchBooks(): List<BookCloud>

    class Base(
        private val services: BookServices,
        private val gson: Gson
    ) : BooksCloudDataSource {
        private val type = object :
            TypeToken<List<BookCloud>>() {}.type // TODO make wrapper

        override suspend fun fetchBooks(): List<BookCloud> =
            gson.fromJson(services.fetchBooks().string(), type)
    }

}

