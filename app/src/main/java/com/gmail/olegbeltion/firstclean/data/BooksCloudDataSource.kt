package com.gmail.olegbeltion.firstclean.data

import com.gmail.olegbeltion.firstclean.data.net.BookServices
import com.gmail.olegbeltion.firstclean.data.net.BookCloud

interface BooksCloudDataSource {
    suspend fun fetchBooks() : List<BookCloud>

    class Base(private val services: BookServices) : BooksCloudDataSource {
        override suspend fun fetchBooks() = services.fetchBooks()

    }
}