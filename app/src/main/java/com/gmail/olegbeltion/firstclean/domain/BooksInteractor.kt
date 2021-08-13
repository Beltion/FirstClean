package com.gmail.olegbeltion.firstclean.domain

import com.gmail.olegbeltion.firstclean.data.BooksRepository
import com.gmail.olegbeltion.firstclean.data.BooksDataToDomainMapper

interface BooksInteractor {
    suspend fun fetchBooks(): BookDomain

    class Base(
        private val booksRepository: BooksRepository,
        private val mapper: BooksDataToDomainMapper
    ) : BooksInteractor {
        override suspend fun fetchBooks() = booksRepository.fetchBooks().map(mapper)
    }
}