package com.gmail.olegbeltion.firstclean.data

import com.gmail.olegbeltion.firstclean.core.Book
import com.gmail.olegbeltion.firstclean.data.cache.BooksCacheDataSource
import com.gmail.olegbeltion.firstclean.data.cache.BooksCacheMapper

interface BooksRepository {

    suspend fun fetchBooks(): BooksData



    class Base(
        private val cloudBooksDs: BooksCloudDataSource,
        private val cacheBooksDs: BooksCacheDataSource,
        private val booksCloudMapper: BooksCloudMapper,
        private val booksCacheMapper: BooksCacheMapper,
    ) : BooksRepository {

        override suspend fun fetchBooks() = try {
            val booksCacheList = cacheBooksDs.fetchBooks()
            if (booksCacheList.isEmpty()) {
                val booksCloudsList = cloudBooksDs.fetchBooks()
                val books = booksCloudMapper.map(booksCloudsList)
                cacheBooksDs.saveBooks(books)
                BooksData.Success(books)
            } else {
                BooksData.Success(booksCacheMapper.map(booksCacheList))
            }


        } catch (e: Exception) {
            BooksData.Fail(e)
        }
    }

}