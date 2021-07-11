package com.gmail.olegbeltion.firstclean.data

interface BooksRepository {

    suspend fun fetchBooks(): BooksData

    class Base(
        private val cloudBooksDs: BooksCloudDataSource,
        private val booksCloudMapper: BooksCloudMapper
    ) : BooksRepository {
        override suspend fun fetchBooks() = try {
            val booksCloudsList = cloudBooksDs.fetchBooks()
            BooksData.Success(booksCloudMapper.map(booksCloudsList))
        } catch (e: Exception) {
            BooksData.Fail(e)
        }


    }

}